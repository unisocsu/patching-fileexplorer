package com.fileexplorer.utils;

import android.os.Environment;
import com.fileexplorer.model.FileItem;
import com.fileexplorer.model.SortOrder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0002J\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u000e\u001a\u00020\u0006J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001a0\u0010J\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000bJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0004J6\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140&2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(H\u0002J\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010\u0016\u001a\u00020\u0017"}, d2 = {"Lcom/fileexplorer/utils/FileRepository;", "", "()V", "copyFile", "", "source", "Ljava/io/File;", "destDir", "createFile", "parent", "name", "", "createFolder", "deleteFile", "file", "getExternalStorageDirectories", "", "getFileDetails", "", "getFiles", "Lcom/fileexplorer/model/FileItem;", "path", "sortOrder", "Lcom/fileexplorer/model/SortOrder;", "showHidden", "getRootPaths", "Lkotlin/Pair;", "moveFile", "renameFile", "newName", "search", "rootPath", "query", "recursive", "searchRecursive", "", "dir", "results", "", "depth", "", "sortFiles", "items"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileRepository {
    public static final FileRepository INSTANCE = new FileRepository();

    /* JADX INFO: compiled from: FileRepository.kt */
    @Metadata(k = Base64.bytesPerGroup, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SortOrder.values().length];
            try {
                iArr[SortOrder.NAME_ASC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SortOrder.NAME_DESC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SortOrder.DATE_ASC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SortOrder.DATE_DESC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SortOrder.SIZE_ASC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SortOrder.SIZE_DESC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SortOrder.TYPE_ASC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FileRepository() {
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004f  */
    public final List<FileItem> getFiles(String path, SortOrder sortOrder, boolean showHidden) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            return CollectionsKt.emptyList();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (!showHidden) {
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (!StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
                    arrayList.add(file2);
                }
            } else {
                arrayList.add(file2);
            }
        }
        ArrayList<File> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (File file3 : arrayList2) {
            Intrinsics.checkNotNull(file3);
            arrayList3.add(new FileItem(file3, null, null, false, 0L, 0L, false, false, 254, null));
        }
        return sortFiles(arrayList3, sortOrder);
    }

    public final List<FileItem> sortFiles(List<FileItem> items, SortOrder sortOrder) {
        List listSortedWith;
        List listSortedWith2;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
        List<FileItem> list = items;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((FileItem) obj).isDirectory()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (true ^ ((FileItem) obj2).isDirectory()) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = arrayList3;
        int i = WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()];
        if (i == 1) {
            listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String lowerCase = ((FileItem) t).getName().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((FileItem) t2).getName().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            });
        } else if (i == 2) {
            listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String lowerCase = ((FileItem) t2).getName().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((FileItem) t).getName().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            });
        } else if (i == 3) {
            listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((FileItem) t).getLastModified()), Long.valueOf(((FileItem) t2).getLastModified()));
                }
            });
        } else if (i == 4) {
            listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((FileItem) t2).getLastModified()), Long.valueOf(((FileItem) t).getLastModified()));
                }
            });
        } else {
            listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedBy$3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String lowerCase = ((FileItem) t).getName().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((FileItem) t2).getName().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            });
        }
        switch (WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()]) {
            case 1:
                listSortedWith2 = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedBy$4
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String lowerCase = ((FileItem) t).getName().toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((FileItem) t2).getName().toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
                break;
            case 2:
                listSortedWith2 = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedByDescending$3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String lowerCase = ((FileItem) t2).getName().toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((FileItem) t).getName().toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
                break;
            case Base64.bytesPerGroup /* 3 */:
                listSortedWith2 = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedBy$6
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((FileItem) t).getLastModified()), Long.valueOf(((FileItem) t2).getLastModified()));
                    }
                });
                break;
            case 4:
                listSortedWith2 = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedByDescending$5
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((FileItem) t2).getLastModified()), Long.valueOf(((FileItem) t).getLastModified()));
                    }
                });
                break;
            case 5:
                listSortedWith2 = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedBy$5
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((FileItem) t).getSize()), Long.valueOf(((FileItem) t2).getSize()));
                    }
                });
                break;
            case 6:
                listSortedWith2 = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$$inlined$sortedByDescending$4
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((FileItem) t2).getSize()), Long.valueOf(((FileItem) t).getSize()));
                    }
                });
                break;
            case 7:
                listSortedWith2 = CollectionsKt.sortedWith(arrayList4, ComparisonsKt.compareBy(new Function1<FileItem, Comparable<?>>() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$sortedFiles$7
                    @Override // kotlin.jvm.functions.Function1
                    public final Comparable<?> invoke(FileItem it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getExtension();
                    }
                }, new Function1<FileItem, Comparable<?>>() { // from class: com.fileexplorer.utils.FileRepository$sortFiles$sortedFiles$8
                    @Override // kotlin.jvm.functions.Function1
                    public final Comparable<?> invoke(FileItem it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String lowerCase = it.getName().toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        return lowerCase;
                    }
                }));
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.plus((Collection) listSortedWith, (Iterable) listSortedWith2);
    }

    public final List<FileItem> search(String rootPath, String query, boolean recursive) {
        Intrinsics.checkNotNullParameter(rootPath, "rootPath");
        Intrinsics.checkNotNullParameter(query, "query");
        ArrayList arrayList = new ArrayList();
        File file = new File(rootPath);
        String lowerCase = query.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        searchRecursive(file, lowerCase, arrayList, recursive, 0);
        return arrayList;
    }

    private final void searchRecursive(File dir, String query, List<FileItem> results, boolean recursive, int depth) {
        File[] fileArrListFiles;
        if (depth <= 5 && (fileArrListFiles = dir.listFiles()) != null) {
            int length = fileArrListFiles.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                File file = fileArrListFiles[i];
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String lowerCase = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.contains$default(lowerCase, query, z, 2, (Object) null)) {
                    Intrinsics.checkNotNull(file);
                    results.add(new FileItem(file, null, null, false, 0L, 0L, false, false, 254, null));
                }
                if (file.isDirectory() && recursive) {
                    Intrinsics.checkNotNull(file);
                    searchRecursive(file, query, results, recursive, depth + 1);
                }
                i++;
                z = false;
            }
        }
    }

    public final List<Pair<String, String>> getRootPaths() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("פנימי", Environment.getExternalStorageDirectory().getAbsolutePath()));
        int i = 0;
        for (Object obj : getExternalStorageDirectories()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new Pair("SD " + i2, (String) obj));
            i = i2;
        }
        arrayList.add(new Pair("שורש", "/"));
        return arrayList;
    }

    private final List<String> getExternalStorageDirectories() {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File("/storage");
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory() && !Intrinsics.areEqual(file2.getName(), "emulated") && !Intrinsics.areEqual(file2.getName(), "self")) {
                        String absolutePath = file2.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        arrayList.add(absolutePath);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final boolean copyFile(File source, File destDir) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        File file = new File(destDir, source.getName());
        if (source.isDirectory()) {
            file.mkdirs();
            File[] fileArrListFiles = source.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    FileRepository fileRepository = INSTANCE;
                    Intrinsics.checkNotNull(file2);
                    fileRepository.copyFile(file2, file);
                }
            }
            return true;
        }
        FileInputStream fileInputStream = new FileInputStream(source);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.copyTo$default(fileInputStream2, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                CloseableKt.closeFinally(fileInputStream, null);
                return true;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileInputStream, th3);
                throw th4;
            }
        }
    }

    public final boolean moveFile(File source, File destDir) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        if (source.renameTo(new File(destDir, source.getName()))) {
            return true;
        }
        try {
            copyFile(source, destDir);
            return FilesKt.deleteRecursively(source);
        } catch (IOException unused) {
            return false;
        }
    }

    public final boolean deleteFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.isDirectory() ? FilesKt.deleteRecursively(file) : file.delete();
    }

    public final boolean renameFile(File file, String newName) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(newName, "newName");
        return file.renameTo(new File(file.getParent(), newName));
    }

    public final boolean createFolder(File parent, String name) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(name, "name");
        return new File(parent, name).mkdirs();
    }

    public final boolean createFile(File parent, String name) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            return new File(parent, name).createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public final Map<String, String> getFileDetails(File file) {
        String upperCase;
        Intrinsics.checkNotNullParameter(file, "file");
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("שם", file.getName());
        pairArr[1] = TuplesKt.to("נתיב", file.getAbsolutePath());
        pairArr[2] = TuplesKt.to("גודל", new FileItem(file, null, null, false, 0L, 0L, false, false, 254, null).getFormattedSize());
        if (file.isDirectory()) {
            upperCase = "תיקייה";
        } else {
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            upperCase = StringsKt.substringAfterLast(name, ".", "").toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        }
        pairArr[3] = TuplesKt.to("סוג", upperCase);
        pairArr[4] = TuplesKt.to("תאריך שינוי", new FileItem(file, null, null, false, 0L, 0L, false, false, 254, null).getFormattedDate());
        pairArr[5] = TuplesKt.to("ניתן לקריאה", file.canRead() ? "כן" : "לא");
        pairArr[6] = TuplesKt.to("ניתן לכתיבה", file.canWrite() ? "כן" : "לא");
        pairArr[7] = TuplesKt.to("מוסתר", file.isHidden() ? "כן" : "לא");
        return MapsKt.mapOf(pairArr);
    }
}
