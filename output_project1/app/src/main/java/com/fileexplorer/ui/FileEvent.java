package com.fileexplorer.ui;

import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileExplorerViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e"}, d2 = {"Lcom/fileexplorer/ui/FileEvent;", "", "()V", "AskConfirm", "AskInput", "OpenFile", "ShowDetails", "ShowError", "ShowMessage", "Lcom/fileexplorer/ui/FileEvent$AskConfirm;", "Lcom/fileexplorer/ui/FileEvent$AskInput;", "Lcom/fileexplorer/ui/FileEvent$OpenFile;", "Lcom/fileexplorer/ui/FileEvent$ShowDetails;", "Lcom/fileexplorer/ui/FileEvent$ShowError;", "Lcom/fileexplorer/ui/FileEvent$ShowMessage;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class FileEvent {
    public /* synthetic */ FileEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FileExplorerViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fileexplorer/ui/FileEvent$ShowMessage;", "Lcom/fileexplorer/ui/FileEvent;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowMessage extends FileEvent {
        private final String message;

        public static /* synthetic */ ShowMessage copy$default(ShowMessage showMessage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showMessage.message;
            }
            return showMessage.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ShowMessage copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ShowMessage(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowMessage) && Intrinsics.areEqual(this.message, ((ShowMessage) other).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ShowMessage(message=" + this.message + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowMessage(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    private FileEvent() {
    }

    /* JADX INFO: compiled from: FileExplorerViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fileexplorer/ui/FileEvent$ShowError;", "Lcom/fileexplorer/ui/FileEvent;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowError extends FileEvent {
        private final String error;

        public static /* synthetic */ ShowError copy$default(ShowError showError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showError.error;
            }
            return showError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final ShowError copy(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new ShowError(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowError) && Intrinsics.areEqual(this.error, ((ShowError) other).error);
        }

        public final String getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "ShowError(error=" + this.error + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowError(String error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }
    }

    /* JADX INFO: compiled from: FileExplorerViewModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f"}, d2 = {"Lcom/fileexplorer/ui/FileEvent$AskConfirm;", "Lcom/fileexplorer/ui/FileEvent;", "title", "", "message", "action", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "getMessage", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AskConfirm extends FileEvent {
        private final Function0<Unit> action;
        private final String message;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AskConfirm copy$default(AskConfirm askConfirm, String str, String str2, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = askConfirm.title;
            }
            if ((i & 2) != 0) {
                str2 = askConfirm.message;
            }
            if ((i & 4) != 0) {
                function0 = askConfirm.action;
            }
            return askConfirm.copy(str, str2, function0);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Function0<Unit> component3() {
            return this.action;
        }

        public final AskConfirm copy(String title, String message, Function0<Unit> action) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(action, "action");
            return new AskConfirm(title, message, action);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AskConfirm)) {
                return false;
            }
            AskConfirm askConfirm = (AskConfirm) other;
            return Intrinsics.areEqual(this.title, askConfirm.title) && Intrinsics.areEqual(this.message, askConfirm.message) && Intrinsics.areEqual(this.action, askConfirm.action);
        }

        public final Function0<Unit> getAction() {
            return this.action;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.message.hashCode()) * 31) + this.action.hashCode();
        }

        public String toString() {
            return "AskConfirm(title=" + this.title + ", message=" + this.message + ", action=" + this.action + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AskConfirm(String title, String message, Function0<Unit> action) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(action, "action");
            this.title = title;
            this.message = message;
            this.action = action;
        }
    }

    /* JADX INFO: compiled from: FileExplorerViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fileexplorer/ui/FileEvent$OpenFile;", "Lcom/fileexplorer/ui/FileEvent;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", ""}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class OpenFile extends FileEvent {
        private final File file;

        public static /* synthetic */ OpenFile copy$default(OpenFile openFile, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = openFile.file;
            }
            return openFile.copy(file);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        public final OpenFile copy(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new OpenFile(file);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OpenFile) && Intrinsics.areEqual(this.file, ((OpenFile) other).file);
        }

        public final File getFile() {
            return this.file;
        }

        public int hashCode() {
            return this.file.hashCode();
        }

        public String toString() {
            return "OpenFile(file=" + this.file + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenFile(File file) {
            super(null);
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
        }
    }

    /* JADX INFO: compiled from: FileExplorerViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fileexplorer/ui/FileEvent$ShowDetails;", "Lcom/fileexplorer/ui/FileEvent;", "details", "", "", "(Ljava/util/Map;)V", "getDetails", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowDetails extends FileEvent {
        private final Map<String, String> details;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShowDetails copy$default(ShowDetails showDetails, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = showDetails.details;
            }
            return showDetails.copy(map);
        }

        public final Map<String, String> component1() {
            return this.details;
        }

        public final ShowDetails copy(Map<String, String> details) {
            Intrinsics.checkNotNullParameter(details, "details");
            return new ShowDetails(details);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowDetails) && Intrinsics.areEqual(this.details, ((ShowDetails) other).details);
        }

        public final Map<String, String> getDetails() {
            return this.details;
        }

        public int hashCode() {
            return this.details.hashCode();
        }

        public String toString() {
            return "ShowDetails(details=" + this.details + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowDetails(Map<String, String> details) {
            super(null);
            Intrinsics.checkNotNullParameter(details, "details");
            this.details = details;
        }
    }

    /* JADX INFO: compiled from: FileExplorerViewModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r"}, d2 = {"Lcom/fileexplorer/ui/FileEvent$AskInput;", "Lcom/fileexplorer/ui/FileEvent;", "title", "", "hint", "prefill", "action", "Lkotlin/Function1;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "getHint", "()Ljava/lang/String;", "getPrefill", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AskInput extends FileEvent {
        private final Function1<String, Unit> action;
        private final String hint;
        private final String prefill;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AskInput copy$default(AskInput askInput, String str, String str2, String str3, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = askInput.title;
            }
            if ((i & 2) != 0) {
                str2 = askInput.hint;
            }
            if ((i & 4) != 0) {
                str3 = askInput.prefill;
            }
            if ((i & 8) != 0) {
                function1 = askInput.action;
            }
            return askInput.copy(str, str2, str3, function1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getHint() {
            return this.hint;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPrefill() {
            return this.prefill;
        }

        public final Function1<String, Unit> component4() {
            return this.action;
        }

        public final AskInput copy(String title, String hint, String prefill, Function1<? super String, Unit> action) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(hint, "hint");
            Intrinsics.checkNotNullParameter(prefill, "prefill");
            Intrinsics.checkNotNullParameter(action, "action");
            return new AskInput(title, hint, prefill, action);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AskInput)) {
                return false;
            }
            AskInput askInput = (AskInput) other;
            return Intrinsics.areEqual(this.title, askInput.title) && Intrinsics.areEqual(this.hint, askInput.hint) && Intrinsics.areEqual(this.prefill, askInput.prefill) && Intrinsics.areEqual(this.action, askInput.action);
        }

        public final Function1<String, Unit> getAction() {
            return this.action;
        }

        public final String getHint() {
            return this.hint;
        }

        public final String getPrefill() {
            return this.prefill;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((this.title.hashCode() * 31) + this.hint.hashCode()) * 31) + this.prefill.hashCode()) * 31) + this.action.hashCode();
        }

        public String toString() {
            return "AskInput(title=" + this.title + ", hint=" + this.hint + ", prefill=" + this.prefill + ", action=" + this.action + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AskInput(String title, String hint, String prefill, Function1<? super String, Unit> action) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(hint, "hint");
            Intrinsics.checkNotNullParameter(prefill, "prefill");
            Intrinsics.checkNotNullParameter(action, "action");
            this.title = title;
            this.hint = hint;
            this.prefill = prefill;
            this.action = action;
        }

        public /* synthetic */ AskInput(String str, String str2, String str3, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? "" : str3, function1);
        }
    }
}
