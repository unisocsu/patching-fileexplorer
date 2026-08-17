package com.fileexplorer.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: FileItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f"}, d2 = {"Lcom/fileexplorer/model/FileType;", "", "(Ljava/lang/String;I)V", "FOLDER", "IMAGE", "AUDIO", "VIDEO", "PDF", "WORD", "EXCEL", "POWERPOINT", "ARCHIVE", "APK", "TEXT", "CODE", "UNKNOWN"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum FileType {
    FOLDER,
    IMAGE,
    AUDIO,
    VIDEO,
    PDF,
    WORD,
    EXCEL,
    POWERPOINT,
    ARCHIVE,
    APK,
    TEXT,
    CODE,
    UNKNOWN;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<FileType> getEntries() {
        return $ENTRIES;
    }
}
