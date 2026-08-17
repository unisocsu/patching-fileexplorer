package com.fileexplorer.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003JY\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\u0013\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001cR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001c\"\u0004\b\u001f\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!"}, d2 = {"Lcom/fileexplorer/model/FileItem;", "", "file", "Ljava/io/File;", "name", "", "path", "isDirectory", "", "size", "", "lastModified", "isSelected", "isFocused", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;ZJJZZ)V", "extension", "getExtension", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "fileType", "Lcom/fileexplorer/model/FileType;", "getFileType", "()Lcom/fileexplorer/model/FileType;", "formattedDate", "getFormattedDate", "formattedSize", "getFormattedSize", "()Z", "setFocused", "(Z)V", "setSelected", "getLastModified", "()J", "getName", "getPath", "getSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class FileItem {
    private final File file;
    private final boolean isDirectory;
    private boolean isFocused;
    private boolean isSelected;
    private final long lastModified;
    private final String name;
    private final String path;
    private final long size;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsDirectory() {
        return this.isDirectory;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getLastModified() {
        return this.lastModified;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    public final FileItem copy(File file, String name, String path, boolean isDirectory, long size, long lastModified, boolean isSelected, boolean isFocused) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        return new FileItem(file, name, path, isDirectory, size, lastModified, isSelected, isFocused);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileItem)) {
            return false;
        }
        FileItem fileItem = (FileItem) other;
        return Intrinsics.areEqual(this.file, fileItem.file) && Intrinsics.areEqual(this.name, fileItem.name) && Intrinsics.areEqual(this.path, fileItem.path) && this.isDirectory == fileItem.isDirectory && this.size == fileItem.size && this.lastModified == fileItem.lastModified && this.isSelected == fileItem.isSelected && this.isFocused == fileItem.isFocused;
    }

    public final File getFile() {
        return this.file;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((((((((((this.file.hashCode() * 31) + this.name.hashCode()) * 31) + this.path.hashCode()) * 31) + FileItem$$ExternalSyntheticBackport0.m(this.isDirectory)) * 31) + FileItem$$ExternalSyntheticBackport0.m(this.size)) * 31) + FileItem$$ExternalSyntheticBackport0.m(this.lastModified)) * 31) + FileItem$$ExternalSyntheticBackport0.m(this.isSelected)) * 31) + FileItem$$ExternalSyntheticBackport0.m(this.isFocused);
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String toString() {
        return "FileItem(file=" + this.file + ", name=" + this.name + ", path=" + this.path + ", isDirectory=" + this.isDirectory + ", size=" + this.size + ", lastModified=" + this.lastModified + ", isSelected=" + this.isSelected + ", isFocused=" + this.isFocused + ')';
    }

    public FileItem(File file, String name, String path, boolean z, long j, long j2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        this.file = file;
        this.name = name;
        this.path = path;
        this.isDirectory = z;
        this.size = j;
        this.lastModified = j2;
        this.isSelected = z2;
        this.isFocused = z3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FileItem(File file, String str, String str2, boolean z, long j, long j2, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String name;
        String absolutePath;
        long length;
        if ((i & 2) != 0) {
            name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        } else {
            name = str;
        }
        if ((i & 4) != 0) {
            absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        } else {
            absolutePath = str2;
        }
        boolean zIsDirectory = (i & 8) != 0 ? file.isDirectory() : z;
        if ((i & 16) != 0) {
            length = file.isDirectory() ? 0L : file.length();
        } else {
            length = j;
        }
        this(file, name, absolutePath, zIsDirectory, length, (i & 32) != 0 ? file.lastModified() : j2, (i & 64) != 0 ? false : z2, (i & 128) == 0 ? z3 : false);
    }

    public final String getExtension() {
        if (this.isDirectory) {
            return "";
        }
        String name = this.file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String strSubstringAfterLast = StringsKt.substringAfterLast(name, ".", "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = strSubstringAfterLast.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final String getFormattedSize() {
        if (this.isDirectory) {
            return "";
        }
        long j = this.size;
        if (j < 1024) {
            return this.size + " B";
        }
        if (j < 1048576) {
            return (this.size / ((long) 1024)) + " KB";
        }
        if (j < 1073741824) {
            return (this.size / ((long) 1048576)) + " MB";
        }
        return (this.size / ((long) 1073741824)) + " GB";
    }

    public final String getFormattedDate() {
        String str = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date(this.lastModified));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final FileType getFileType() {
        if (this.isDirectory) {
            return FileType.FOLDER;
        }
        if (CollectionsKt.listOf((Object[]) new String[]{"jpg", "jpeg", "png", "gif", "bmp", "webp"}).contains(getExtension())) {
            return FileType.IMAGE;
        }
        if (CollectionsKt.listOf((Object[]) new String[]{"mp3", "wav", "ogg", "m4a", "flac", "aac"}).contains(getExtension())) {
            return FileType.AUDIO;
        }
        if (CollectionsKt.listOf((Object[]) new String[]{"mp4", "avi", "mkv", "mov", "wmv", "3gp"}).contains(getExtension())) {
            return FileType.VIDEO;
        }
        if (CollectionsKt.listOf("pdf").contains(getExtension())) {
            return FileType.PDF;
        }
        if (CollectionsKt.listOf((Object[]) new String[]{"doc", "docx", "odt"}).contains(getExtension())) {
            return FileType.WORD;
        }
        if (CollectionsKt.listOf((Object[]) new String[]{"xls", "xlsx", "ods"}).contains(getExtension())) {
            return FileType.EXCEL;
        }
        if (CollectionsKt.listOf((Object[]) new String[]{"ppt", "pptx", "odp"}).contains(getExtension())) {
            return FileType.POWERPOINT;
        }
        if (CollectionsKt.listOf((Object[]) new String[]{"zip", "rar", "7z", "tar", "gz", "bz2"}).contains(getExtension())) {
            return FileType.ARCHIVE;
        }
        if (CollectionsKt.listOf("apk").contains(getExtension())) {
            return FileType.APK;
        }
        if (CollectionsKt.listOf((Object[]) new String[]{"txt", "log", "md", "csv"}).contains(getExtension())) {
            return FileType.TEXT;
        }
        return CollectionsKt.listOf((Object[]) new String[]{"java", "kt", "py", "js", "html", "css", "xml", "json", "c", "cpp", "h"}).contains(getExtension()) ? FileType.CODE : FileType.UNKNOWN;
    }
}
