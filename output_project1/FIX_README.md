# com.fileexplorer — קריסה בעליית האפליקציה (תוקן)

## הבעיה
```
java.lang.NoSuchMethodError: com.fileexplorer.ui.MainActivity.checkSelfPermission
    at com.fileexplorer.ui.MainActivity.hasPerms(MainActivity.kt:475)
    at com.fileexplorer.ui.MainActivity.onCreate(MainActivity.kt:124)
```
`checkSelfPermission()` ו-`requestPermissions()` (בלי `ContextCompat`) קיימות רק
מ-API 23 (Android 6.0) ומעלה. במכשיר עם Android ישן יותר השיטות האלה לא קיימות
בכלל ברמת ה-runtime, מה שגורם ל-NoSuchMethodError מיד עם עליית האפליקציה.

## התיקון
בקובץ `app/src/main/java/com/fileexplorer/ui/MainActivity.java`, בפונקציות
`hasPerms()` ו-`requestPerms()`, נוספה בדיקת `Build.VERSION.SDK_INT >= 23` לפני
הקריאה לשיטות האלה. מתחת ל-API 23 ההרשאות ניתנות אוטומטית בזמן ההתקנה
(דרך ה-manifest), אז אין צורך (ואי אפשר) לבקש אותן ב-runtime — `hasPerms()`
פשוט מחזיר `true` ו-`requestPerms()` קורא ישירות ל-`initNav()`.

## חשוב לפני שבונים ב-GitHub Actions / Android Studio
הקובץ הזה יצא מדה-קומפילציה (jadx) ולא קוד מקור מקורי, אז יש כמה דברים שכדאי
לצפות להם:

1. **`build.gradle` מולא בערכים בסיסיים** (compileSdk 34, minSdk 16,
   targetSdk 34, dependency ל-`kotlin-stdlib`) כי הקוד המפוענח עדיין קורא
   למחלקות runtime של Kotlin (`Intrinsics`, `Function0/1/2`, `Unit`, `Pair`
   וכו') למרות שהוא כתוב עכשיו כ-`.java`. יכול להיות שיהיה צורך לכוונן גרסאות.
2. **קבצים נוספים בפרויקט** (`FileAdapter`, `FileExplorerViewModel`,
   `FileRepository` וכו') לא נבדקו/תוקנו — רק `MainActivity.java`. אם יש
   שימושים דומים ב-API חדש בקבצים אחרים, יכולות להיות קריסות נוספות באותו
   אופן במכשירים ישנים.
3. **קבצי משאבים (res/)** מ-jadx לפעמים חלקיים או משוחזרים בצורה לא מושלמת —
   כדאי לוודא שכל ה-drawables/layouts/strings קיימים לפני build.
4. אם ה-build נכשל על שגיאות קומפילציה רבות, לרוב יעיל יותר לתקן ישירות את
   ה-`.smali` בתוך ה-APK המקורי (patch ברמת bytecode) ולא לנסות להרכיב
   מחדש את כל הפרויקט מהקוד המפוענח.
