package com.fileexplorer.ui;

import com.fileexplorer.model.FileItem;
import com.fileexplorer.model.FileItem$$ExternalSyntheticBackport0;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileExplorerViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0013HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\rHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0011HÆ\u0003J\u0081\u0001\u0010-\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0013HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001fR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\""}, d2 = {"Lcom/fileexplorer/ui/UiState;", "", "files", "", "Lcom/fileexplorer/model/FileItem;", "currentPath", "", "isLoading", "", "error", "isSearchMode", "searchQuery", "selectedFiles", "", "clipboardFiles", "Ljava/io/File;", "clipboardMode", "Lcom/fileexplorer/ui/ClipboardMode;", "focusedIndex", "", "(Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/util/Set;Ljava/util/List;Lcom/fileexplorer/ui/ClipboardMode;I)V", "getClipboardFiles", "()Ljava/util/List;", "getClipboardMode", "()Lcom/fileexplorer/ui/ClipboardMode;", "getCurrentPath", "()Ljava/lang/String;", "getError", "getFiles", "getFocusedIndex", "()I", "()Z", "getSearchQuery", "getSelectedFiles", "()Ljava/util/Set;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class UiState {
    private final List<File> clipboardFiles;
    private final ClipboardMode clipboardMode;
    private final String currentPath;
    private final String error;
    private final List<FileItem> files;
    private final int focusedIndex;
    private final boolean isLoading;
    private final boolean isSearchMode;
    private final String searchQuery;
    private final Set<String> selectedFiles;

    public UiState() {
        this(null, null, false, null, false, null, null, null, null, 0, 1023, null);
    }

    public final List<FileItem> component1() {
        return this.files;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getFocusedIndex() {
        return this.focusedIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCurrentPath() {
        return this.currentPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSearchMode() {
        return this.isSearchMode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final Set<String> component7() {
        return this.selectedFiles;
    }

    public final List<File> component8() {
        return this.clipboardFiles;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ClipboardMode getClipboardMode() {
        return this.clipboardMode;
    }

    public final UiState copy(List<FileItem> files, String currentPath, boolean isLoading, String error, boolean isSearchMode, String searchQuery, Set<String> selectedFiles, List<? extends File> clipboardFiles, ClipboardMode clipboardMode, int focusedIndex) {
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(currentPath, "currentPath");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(selectedFiles, "selectedFiles");
        Intrinsics.checkNotNullParameter(clipboardFiles, "clipboardFiles");
        Intrinsics.checkNotNullParameter(clipboardMode, "clipboardMode");
        return new UiState(files, currentPath, isLoading, error, isSearchMode, searchQuery, selectedFiles, clipboardFiles, clipboardMode, focusedIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiState)) {
            return false;
        }
        UiState uiState = (UiState) other;
        return Intrinsics.areEqual(this.files, uiState.files) && Intrinsics.areEqual(this.currentPath, uiState.currentPath) && this.isLoading == uiState.isLoading && Intrinsics.areEqual(this.error, uiState.error) && this.isSearchMode == uiState.isSearchMode && Intrinsics.areEqual(this.searchQuery, uiState.searchQuery) && Intrinsics.areEqual(this.selectedFiles, uiState.selectedFiles) && Intrinsics.areEqual(this.clipboardFiles, uiState.clipboardFiles) && this.clipboardMode == uiState.clipboardMode && this.focusedIndex == uiState.focusedIndex;
    }

    public final List<File> getClipboardFiles() {
        return this.clipboardFiles;
    }

    public final ClipboardMode getClipboardMode() {
        return this.clipboardMode;
    }

    public final String getCurrentPath() {
        return this.currentPath;
    }

    public final String getError() {
        return this.error;
    }

    public final List<FileItem> getFiles() {
        return this.files;
    }

    public final int getFocusedIndex() {
        return this.focusedIndex;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final Set<String> getSelectedFiles() {
        return this.selectedFiles;
    }

    public int hashCode() {
        int iHashCode = ((((this.files.hashCode() * 31) + this.currentPath.hashCode()) * 31) + FileItem$$ExternalSyntheticBackport0.m(this.isLoading)) * 31;
        String str = this.error;
        return ((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + FileItem$$ExternalSyntheticBackport0.m(this.isSearchMode)) * 31) + this.searchQuery.hashCode()) * 31) + this.selectedFiles.hashCode()) * 31) + this.clipboardFiles.hashCode()) * 31) + this.clipboardMode.hashCode()) * 31) + this.focusedIndex;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isSearchMode() {
        return this.isSearchMode;
    }

    public String toString() {
        return "UiState(files=" + this.files + ", currentPath=" + this.currentPath + ", isLoading=" + this.isLoading + ", error=" + this.error + ", isSearchMode=" + this.isSearchMode + ", searchQuery=" + this.searchQuery + ", selectedFiles=" + this.selectedFiles + ", clipboardFiles=" + this.clipboardFiles + ", clipboardMode=" + this.clipboardMode + ", focusedIndex=" + this.focusedIndex + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UiState(List<FileItem> files, String currentPath, boolean z, String str, boolean z2, String searchQuery, Set<String> selectedFiles, List<? extends File> clipboardFiles, ClipboardMode clipboardMode, int i) {
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(currentPath, "currentPath");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(selectedFiles, "selectedFiles");
        Intrinsics.checkNotNullParameter(clipboardFiles, "clipboardFiles");
        Intrinsics.checkNotNullParameter(clipboardMode, "clipboardMode");
        this.files = files;
        this.currentPath = currentPath;
        this.isLoading = z;
        this.error = str;
        this.isSearchMode = z2;
        this.searchQuery = searchQuery;
        this.selectedFiles = selectedFiles;
        this.clipboardFiles = clipboardFiles;
        this.clipboardMode = clipboardMode;
        this.focusedIndex = i;
    }

    public /* synthetic */ UiState(List list, String str, boolean z, String str2, boolean z2, String str3, Set set, List list2, ClipboardMode clipboardMode, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? false : z2, (i2 & 32) == 0 ? str3 : "", (i2 & 64) != 0 ? SetsKt.emptySet() : set, (i2 & 128) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 256) != 0 ? ClipboardMode.NONE : clipboardMode, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) == 0 ? i : 0);
    }
}
