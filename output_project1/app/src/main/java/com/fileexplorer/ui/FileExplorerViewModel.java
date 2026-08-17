package com.fileexplorer.ui;

import com.fileexplorer.model.FileItem;
import com.fileexplorer.model.SortOrder;
import com.fileexplorer.model.ViewMode;
import com.fileexplorer.utils.FileRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.ConstantsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileExplorerViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020)J\u0006\u0010-\u001a\u00020)J\u0006\u0010.\u001a\u00020)J\u0006\u0010/\u001a\u00020)J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0010\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\nH\u0002J\u000e\u00107\u001a\u00020)2\u0006\u00106\u001a\u00020\nJ\u000e\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020)2\u0006\u00109\u001a\u00020:J\u0006\u0010<\u001a\u00020)J\u0010\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u000fH\u0002J\u0006\u0010?\u001a\u00020)J\u000e\u0010@\u001a\u00020)2\u0006\u00109\u001a\u00020:J\u000e\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020\nJ\u0006\u0010C\u001a\u00020)J\u000e\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\u001dJ\u000e\u0010I\u001a\u00020)2\u0006\u00109\u001a\u00020:J\u0006\u0010J\u001a\u00020)J\u000e\u0010K\u001a\u00020)2\u0006\u00106\u001a\u00020\nJ\u0006\u0010L\u001a\u00020)R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u001e\u0010%\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'"}, d2 = {"Lcom/fileexplorer/ui/FileExplorerViewModel;", "", "()V", "canGoBack", "", "getCanGoBack", "()Z", "canGoForward", "getCanGoForward", "currentPath", "", "getCurrentPath", "()Ljava/lang/String;", "events", "Lcom/fileexplorer/ui/Observable;", "Lcom/fileexplorer/ui/FileEvent;", "getEvents", "()Lcom/fileexplorer/ui/Observable;", "forwardHistory", "Lkotlin/collections/ArrayDeque;", "history", "isSelectionMode", "selectedFiles", "", "getSelectedFiles", "()Ljava/util/Set;", "<set-?>", "showHidden", "getShowHidden", "Lcom/fileexplorer/model/SortOrder;", "sortOrder", "getSortOrder", "()Lcom/fileexplorer/model/SortOrder;", "uiState", "Lcom/fileexplorer/ui/UiState;", "getUiState", "Lcom/fileexplorer/model/ViewMode;", "viewMode", "getViewMode", "()Lcom/fileexplorer/model/ViewMode;", "clearSelection", "", "copySelected", "createFile", "createFolder", "cutSelected", "deleteSelected", "eventHandled", "getSelectedFileObjects", "", "Ljava/io/File;", "goBack", "goForward", "loadDirectory", "path", "navigateTo", "onItemActivated", "item", "Lcom/fileexplorer/model/FileItem;", "openFile", "paste", "postEvent", "e", "refresh", "renameFile", "search", "query", "selectAll", "setFocusedIndex", "i", "", "setSortOrder", "order", "showDetails", "toggleHidden", "toggleSelection", "toggleViewMode"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileExplorerViewModel {
    private boolean showHidden;
    private final Observable<UiState> uiState = new Observable<>(new UiState(null, null, false, null, false, null, null, null, null, 0, 1023, null));
    private final Observable<FileEvent> events = new Observable<>(null);
    private final ArrayDeque<String> history = new ArrayDeque<>();
    private final ArrayDeque<String> forwardHistory = new ArrayDeque<>();
    private SortOrder sortOrder = SortOrder.NAME_ASC;
    private ViewMode viewMode = ViewMode.LIST;

    public final Observable<FileEvent> getEvents() {
        return this.events;
    }

    public final boolean getShowHidden() {
        return this.showHidden;
    }

    public final SortOrder getSortOrder() {
        return this.sortOrder;
    }

    public final Observable<UiState> getUiState() {
        return this.uiState;
    }

    public final ViewMode getViewMode() {
        return this.viewMode;
    }

    public final String getCurrentPath() {
        return this.uiState.getValue().getCurrentPath();
    }

    public final Set<String> getSelectedFiles() {
        return this.uiState.getValue().getSelectedFiles();
    }

    public final boolean isSelectionMode() {
        return !getSelectedFiles().isEmpty();
    }

    public final boolean getCanGoBack() {
        return !this.history.isEmpty();
    }

    public final boolean getCanGoForward() {
        return !this.forwardHistory.isEmpty();
    }

    public final void navigateTo(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String currentPath = getCurrentPath();
        if (currentPath.length() > 0) {
            this.history.addLast(currentPath);
            this.forwardHistory.clear();
        }
        loadDirectory(path);
    }

    public final boolean goBack() {
        if (this.history.isEmpty()) {
            return false;
        }
        this.forwardHistory.addFirst(getCurrentPath());
        loadDirectory(this.history.removeLast());
        return true;
    }

    public final boolean goForward() {
        if (this.forwardHistory.isEmpty()) {
            return false;
        }
        this.history.addLast(getCurrentPath());
        loadDirectory(this.forwardHistory.removeFirst());
        return true;
    }

    public final void refresh() {
        if (getCurrentPath().length() > 0) {
            loadDirectory(getCurrentPath());
        }
    }

    private final void loadDirectory(String path) {
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : null, (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : true, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : false, (1003 & 32) != 0 ? value.searchQuery : null, (1003 & 64) != 0 ? value.selectedFiles : null, (1003 & 128) != 0 ? value.clipboardFiles : null, (1003 & 256) != 0 ? value.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : 0));
        try {
            List<FileItem> files = FileRepository.INSTANCE.getFiles(path, this.sortOrder, this.showHidden);
            Observable<UiState> observable2 = this.uiState;
            UiState value2 = observable2.getValue();
            observable2.setValue(value2.copy((1003 & 1) != 0 ? value2.files : files, (1003 & 2) != 0 ? value2.currentPath : path, (1003 & 4) != 0 ? value2.isLoading : false, (1003 & 8) != 0 ? value2.error : null, (1003 & 16) != 0 ? value2.isSearchMode : false, (1003 & 32) != 0 ? value2.searchQuery : null, (1003 & 64) != 0 ? value2.selectedFiles : SetsKt.emptySet(), (1003 & 128) != 0 ? value2.clipboardFiles : null, (1003 & 256) != 0 ? value2.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value2.focusedIndex : 0));
        } catch (Exception e) {
            Observable<UiState> observable3 = this.uiState;
            UiState value3 = observable3.getValue();
            observable3.setValue(value3.copy((1003 & 1) != 0 ? value3.files : null, (1003 & 2) != 0 ? value3.currentPath : null, (1003 & 4) != 0 ? value3.isLoading : false, (1003 & 8) != 0 ? value3.error : e.getMessage(), (1003 & 16) != 0 ? value3.isSearchMode : false, (1003 & 32) != 0 ? value3.searchQuery : null, (1003 & 64) != 0 ? value3.selectedFiles : null, (1003 & 128) != 0 ? value3.clipboardFiles : null, (1003 & 256) != 0 ? value3.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value3.focusedIndex : 0));
        }
    }

    public final void search(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        if (StringsKt.isBlank(query)) {
            refresh();
            return;
        }
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : null, (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : true, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : true, (1003 & 32) != 0 ? value.searchQuery : query, (1003 & 64) != 0 ? value.selectedFiles : null, (1003 & 128) != 0 ? value.clipboardFiles : null, (1003 & 256) != 0 ? value.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : 0));
        try {
            List<FileItem> listSearch = FileRepository.INSTANCE.search(getCurrentPath(), query, true);
            Observable<UiState> observable2 = this.uiState;
            UiState value2 = observable2.getValue();
            observable2.setValue(value2.copy((1003 & 1) != 0 ? value2.files : listSearch, (1003 & 2) != 0 ? value2.currentPath : null, (1003 & 4) != 0 ? value2.isLoading : false, (1003 & 8) != 0 ? value2.error : null, (1003 & 16) != 0 ? value2.isSearchMode : false, (1003 & 32) != 0 ? value2.searchQuery : null, (1003 & 64) != 0 ? value2.selectedFiles : SetsKt.emptySet(), (1003 & 128) != 0 ? value2.clipboardFiles : null, (1003 & 256) != 0 ? value2.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value2.focusedIndex : 0));
        } catch (Exception e) {
            Observable<UiState> observable3 = this.uiState;
            UiState value3 = observable3.getValue();
            observable3.setValue(value3.copy((1003 & 1) != 0 ? value3.files : null, (1003 & 2) != 0 ? value3.currentPath : null, (1003 & 4) != 0 ? value3.isLoading : false, (1003 & 8) != 0 ? value3.error : e.getMessage(), (1003 & 16) != 0 ? value3.isSearchMode : false, (1003 & 32) != 0 ? value3.searchQuery : null, (1003 & 64) != 0 ? value3.selectedFiles : null, (1003 & 128) != 0 ? value3.clipboardFiles : null, (1003 & 256) != 0 ? value3.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value3.focusedIndex : 0));
        }
    }

    public final void setSortOrder(SortOrder order) {
        Intrinsics.checkNotNullParameter(order, "order");
        this.sortOrder = order;
        List<FileItem> files = this.uiState.getValue().getFiles();
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : FileRepository.INSTANCE.sortFiles(files, order), (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : false, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : false, (1003 & 32) != 0 ? value.searchQuery : null, (1003 & 64) != 0 ? value.selectedFiles : null, (1003 & 128) != 0 ? value.clipboardFiles : null, (1003 & 256) != 0 ? value.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : 0));
    }

    public final void toggleViewMode() {
        this.viewMode = this.viewMode == ViewMode.LIST ? ViewMode.GRID : ViewMode.LIST;
    }

    public final void toggleHidden() {
        this.showHidden = !this.showHidden;
        refresh();
    }

    public final void toggleSelection(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Set mutableSet = CollectionsKt.toMutableSet(this.uiState.getValue().getSelectedFiles());
        if (mutableSet.contains(path)) {
            mutableSet.remove(path);
        } else {
            mutableSet.add(path);
        }
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : null, (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : false, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : false, (1003 & 32) != 0 ? value.searchQuery : null, (1003 & 64) != 0 ? value.selectedFiles : mutableSet, (1003 & 128) != 0 ? value.clipboardFiles : null, (1003 & 256) != 0 ? value.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : 0));
    }

    public final void selectAll() {
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        List<FileItem> files = this.uiState.getValue().getFiles();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(files, 10));
        Iterator<T> it = files.iterator();
        while (it.hasNext()) {
            arrayList.add(((FileItem) it.next()).getPath());
        }
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : null, (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : false, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : false, (1003 & 32) != 0 ? value.searchQuery : null, (1003 & 64) != 0 ? value.selectedFiles : CollectionsKt.toSet(arrayList), (1003 & 128) != 0 ? value.clipboardFiles : null, (1003 & 256) != 0 ? value.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : 0));
    }

    public final void clearSelection() {
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : null, (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : false, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : false, (1003 & 32) != 0 ? value.searchQuery : null, (1003 & 64) != 0 ? value.selectedFiles : SetsKt.emptySet(), (1003 & 128) != 0 ? value.clipboardFiles : null, (1003 & 256) != 0 ? value.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : 0));
    }

    public final void setFocusedIndex(int i) {
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : null, (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : false, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : false, (1003 & 32) != 0 ? value.searchQuery : null, (1003 & 64) != 0 ? value.selectedFiles : null, (1003 & 128) != 0 ? value.clipboardFiles : null, (1003 & 256) != 0 ? value.clipboardMode : null, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : i));
    }

    public final void copySelected() {
        List<File> selectedFileObjects = getSelectedFileObjects();
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : null, (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : false, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : false, (1003 & 32) != 0 ? value.searchQuery : null, (1003 & 64) != 0 ? value.selectedFiles : SetsKt.emptySet(), (1003 & 128) != 0 ? value.clipboardFiles : selectedFileObjects, (1003 & 256) != 0 ? value.clipboardMode : ClipboardMode.COPY, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : 0));
        postEvent(new FileEvent.ShowMessage(selectedFileObjects.size() + " קבצים הועתקו ללוח"));
    }

    public final void cutSelected() {
        List<File> selectedFileObjects = getSelectedFileObjects();
        Observable<UiState> observable = this.uiState;
        UiState value = observable.getValue();
        observable.setValue(value.copy((1003 & 1) != 0 ? value.files : null, (1003 & 2) != 0 ? value.currentPath : null, (1003 & 4) != 0 ? value.isLoading : false, (1003 & 8) != 0 ? value.error : null, (1003 & 16) != 0 ? value.isSearchMode : false, (1003 & 32) != 0 ? value.searchQuery : null, (1003 & 64) != 0 ? value.selectedFiles : SetsKt.emptySet(), (1003 & 128) != 0 ? value.clipboardFiles : selectedFileObjects, (1003 & 256) != 0 ? value.clipboardMode : ClipboardMode.CUT, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value.focusedIndex : 0));
        postEvent(new FileEvent.ShowMessage(selectedFileObjects.size() + " קבצים גזורים ללוח"));
    }

    public final void paste() {
        UiState value = this.uiState.getValue();
        if (value.getClipboardFiles().isEmpty()) {
            return;
        }
        File file = new File(getCurrentPath());
        int i = 0;
        int i2 = 0;
        for (File file2 : value.getClipboardFiles()) {
            try {
                if (value.getClipboardMode() == ClipboardMode.COPY ? FileRepository.INSTANCE.copyFile(file2, file) : FileRepository.INSTANCE.moveFile(file2, file)) {
                    i++;
                } else {
                    i2++;
                }
            } catch (Exception unused) {
            }
        }
        if (value.getClipboardMode() == ClipboardMode.CUT) {
            Observable<UiState> observable = this.uiState;
            UiState value2 = observable.getValue();
            observable.setValue(value2.copy((1003 & 1) != 0 ? value2.files : null, (1003 & 2) != 0 ? value2.currentPath : null, (1003 & 4) != 0 ? value2.isLoading : false, (1003 & 8) != 0 ? value2.error : null, (1003 & 16) != 0 ? value2.isSearchMode : false, (1003 & 32) != 0 ? value2.searchQuery : null, (1003 & 64) != 0 ? value2.selectedFiles : null, (1003 & 128) != 0 ? value2.clipboardFiles : CollectionsKt.emptyList(), (1003 & 256) != 0 ? value2.clipboardMode : ClipboardMode.NONE, (1003 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? value2.focusedIndex : 0));
        }
        refresh();
        StringBuilder sb = new StringBuilder("הועברו ");
        sb.append(i);
        sb.append(" קבצים");
        sb.append(i2 > 0 ? ", נכשלו " + i2 : "");
        postEvent(new FileEvent.ShowMessage(sb.toString()));
    }

    public final void deleteSelected() {
        final List<File> selectedFileObjects = getSelectedFileObjects();
        postEvent(new FileEvent.AskConfirm("מחיקה", "למחוק " + selectedFileObjects.size() + " פריטים?", new Function0<Unit>() { // from class: com.fileexplorer.ui.FileExplorerViewModel.deleteSelected.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Iterator<T> it = selectedFileObjects.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (FileRepository.INSTANCE.deleteFile((File) it.next())) {
                        i++;
                    }
                }
                this.clearSelection();
                this.refresh();
                this.postEvent(new FileEvent.ShowMessage("נמחקו " + i + " פריטים"));
            }
        }));
    }

    public final void renameFile(final FileItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        postEvent(new FileEvent.AskInput("שנה שם", "שם חדש", item.getName(), new Function1<String, Unit>() { // from class: com.fileexplorer.ui.FileExplorerViewModel.renameFile.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                if (!(!StringsKt.isBlank(name)) || Intrinsics.areEqual(name, item.getName())) {
                    return;
                }
                if (FileRepository.INSTANCE.renameFile(item.getFile(), name)) {
                    this.refresh();
                    this.postEvent(new FileEvent.ShowMessage("שונה שם בהצלחה"));
                } else {
                    this.postEvent(new FileEvent.ShowError("שגיאה בשינוי שם"));
                }
            }
        }));
    }

    public final void createFolder() {
        postEvent(new FileEvent.AskInput("תיקייה חדשה", "שם תיקייה", null, new Function1<String, Unit>() { // from class: com.fileexplorer.ui.FileExplorerViewModel.createFolder.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                if (!StringsKt.isBlank(name)) {
                    if (FileRepository.INSTANCE.createFolder(new File(FileExplorerViewModel.this.getCurrentPath()), name)) {
                        FileExplorerViewModel.this.refresh();
                        FileExplorerViewModel.this.postEvent(new FileEvent.ShowMessage("תיקייה נוצרה"));
                    } else {
                        FileExplorerViewModel.this.postEvent(new FileEvent.ShowError("שגיאה ביצירת תיקייה"));
                    }
                }
            }
        }, 4, null));
    }

    public final void createFile() {
        postEvent(new FileEvent.AskInput("קובץ חדש", "שם קובץ", null, new Function1<String, Unit>() { // from class: com.fileexplorer.ui.FileExplorerViewModel.createFile.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                if (!StringsKt.isBlank(name)) {
                    if (FileRepository.INSTANCE.createFile(new File(FileExplorerViewModel.this.getCurrentPath()), name)) {
                        FileExplorerViewModel.this.refresh();
                        FileExplorerViewModel.this.postEvent(new FileEvent.ShowMessage("קובץ נוצר"));
                    } else {
                        FileExplorerViewModel.this.postEvent(new FileEvent.ShowError("שגיאה ביצירת קובץ"));
                    }
                }
            }
        }, 4, null));
    }

    public final void showDetails(FileItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        postEvent(new FileEvent.ShowDetails(FileRepository.INSTANCE.getFileDetails(item.getFile())));
    }

    public final void openFile(FileItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        postEvent(new FileEvent.OpenFile(item.getFile()));
    }

    public final void onItemActivated(FileItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.isDirectory()) {
            navigateTo(item.getPath());
        } else {
            openFile(item);
        }
    }

    public final void eventHandled() {
        this.events.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postEvent(FileEvent e) {
        this.events.setValue(e);
    }

    private final List<File> getSelectedFileObjects() {
        List<FileItem> files = this.uiState.getValue().getFiles();
        ArrayList arrayList = new ArrayList();
        for (Object obj : files) {
            if (getSelectedFiles().contains(((FileItem) obj).getPath())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((FileItem) it.next()).getFile());
        }
        return arrayList3;
    }
}
