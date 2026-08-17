package com.fileexplorer.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.fileexplorer.R;
import com.fileexplorer.adapter.FileAdapter;
import com.fileexplorer.model.FileItem;
import com.fileexplorer.model.FileItem$$ExternalSyntheticBackport0;
import com.fileexplorer.model.SortOrder;
import com.fileexplorer.model.ViewMode;
import com.fileexplorer.provider.AppFileProvider;
import com.fileexplorer.utils.FileRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001WB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001dH\u0002J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020 H\u0002J\"\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0012\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000207H\u0016J+\u00108\u001a\u00020 2\u0006\u0010.\u001a\u00020\u00042\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020 H\u0002J\b\u0010C\u001a\u00020 H\u0002J\u001c\u0010D\u001a\u00020 2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;0FH\u0002J4\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020;2\u0006\u0010J\u001a\u00020;2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020 0LH\u0002J\u0010\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020\u000eH\u0002J\u001e\u0010O\u001a\u00020 2\u0006\u0010N\u001a\u00020\u000e2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0QH\u0002J\u0010\u0010S\u001a\u00020 2\u0006\u0010N\u001a\u00020\u000eH\u0002J\u0010\u0010T\u001a\u00020 2\u0006\u0010N\u001a\u00020\u000eH\u0002J\b\u0010U\u001a\u00020 H\u0002J\b\u0010V\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000"}, d2 = {"Lcom/fileexplorer/ui/MainActivity;", "Landroid/app/Activity;", "()V", "PERM_REQ", "", "adapter", "Lcom/fileexplorer/adapter/FileAdapter;", "breadcrumb", "Landroid/widget/TextView;", "btnBack", "Landroid/widget/ImageButton;", "btnForward", "btnPaste", "emptyView", "Landroid/view/View;", "focusAnchor", "gridView", "Landroid/widget/GridView;", "listView", "Landroid/widget/ListView;", "progressBar", "Landroid/widget/ProgressBar;", "selectionBar", "selectionCount", "vm", "Lcom/fileexplorer/ui/FileExplorerViewModel;", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "gridColumnCount", "handleClick", "", "item", "Lcom/fileexplorer/model/FileItem;", "pos", "handleListKey", "ev", "handleLongClick", "hasPerms", "initNav", "isListFocused", "moveFocus", "idx", "observeVm", "onActivityResult", "req", "res", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onRequestPermissionsResult", "perms", "", "", "grants", "", "(I[Ljava/lang/String;[I)V", "openFile", "file", "Ljava/io/File;", "requestPerms", "showAddMenu", "showDetailsDialog", "details", "", "showInputDialog", "title", "hint", "prefill", "action", "Lkotlin/Function1;", "showOverflowMenu", "anchor", "showPopupMenu", "rows", "", "Lcom/fileexplorer/ui/MainActivity$PopupRow;", "showSortPopup", "showStoragePopup", "switchViewMode", "updateViewModeVisibility", "PopupRow"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainActivity extends Activity {
    private final int PERM_REQ = 1001;
    private FileAdapter adapter;
    private TextView breadcrumb;
    private ImageButton btnBack;
    private ImageButton btnForward;
    private ImageButton btnPaste;
    private View emptyView;
    private View focusAnchor;
    private GridView gridView;
    private ListView listView;
    private ProgressBar progressBar;
    private View selectionBar;
    private TextView selectionCount;
    private FileExplorerViewModel vm;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewFindViewById = findViewById(R.id.listView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.listView = (ListView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.gridView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.gridView = (GridView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.progressBar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.emptyView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.emptyView = viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.breadcrumbText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.breadcrumb = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.btnBack);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.btnBack = (ImageButton) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.btnForward);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.btnForward = (ImageButton) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.selectionBar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.selectionBar = viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.selectionCount);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.selectionCount = (TextView) viewFindViewById9;
        View viewFindViewById10 = findViewById(R.id.btnPaste);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.btnPaste = (ImageButton) viewFindViewById10;
        this.vm = new FileExplorerViewModel();
        this.adapter = new FileAdapter(this, ViewMode.LIST, new Function2<FileItem, Integer, Unit>() { // from class: com.fileexplorer.ui.MainActivity.onCreate.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(FileItem fileItem, Integer num) {
                invoke(fileItem, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(FileItem item, int i) {
                Intrinsics.checkNotNullParameter(item, "item");
                MainActivity.this.handleClick(item, i);
            }
        }, new Function2<FileItem, Integer, Boolean>() { // from class: com.fileexplorer.ui.MainActivity.onCreate.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(FileItem fileItem, Integer num) {
                return invoke(fileItem, num.intValue());
            }

            public final Boolean invoke(FileItem item, int i) {
                Intrinsics.checkNotNullParameter(item, "item");
                return Boolean.valueOf(MainActivity.this.handleLongClick(item, i));
            }
        });
        ListView listView2 = this.listView;
        if (listView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView2 = null;
        }
        FileAdapter fileAdapter = this.adapter;
        if (fileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fileAdapter = null;
        }
        listView2.setAdapter((ListAdapter) fileAdapter);
        GridView gridView = this.gridView;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridView");
            gridView = null;
        }
        FileAdapter fileAdapter2 = this.adapter;
        if (fileAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fileAdapter2 = null;
        }
        gridView.setAdapter((ListAdapter) fileAdapter2);
        View[] viewArr = new View[2];
        ListView listView3 = this.listView;
        if (listView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView3 = null;
        }
        viewArr[0] = listView3;
        GridView gridView2 = this.gridView;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridView");
            gridView2 = null;
        }
        viewArr[1] = gridView2;
        for (View view : CollectionsKt.listOf((Object[]) viewArr)) {
            view.setFocusable(false);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).setDescendantFocusability(393216);
        }
        updateViewModeVisibility();
        View viewFindViewById11 = findViewById(R.id.focusAnchor);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.focusAnchor = viewFindViewById11;
        ImageButton imageButton = this.btnBack;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageButton = null;
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$0(this.f$0, view2);
            }
        });
        ImageButton imageButton2 = this.btnForward;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnForward");
            imageButton2 = null;
        }
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$1(this.f$0, view2);
            }
        });
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.btnHome);
        imageButton3.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$2(this.f$0, view2);
            }
        });
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.btnClearSelection);
        ImageButton imageButton5 = (ImageButton) findViewById(R.id.btnSelectAll);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.btnCopy);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.btnCut);
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.btnDelete);
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.fabAdd);
        final ImageButton imageButton10 = (ImageButton) findViewById(R.id.btnMore);
        imageButton4.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$3(this.f$0, view2);
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$4(this.f$0, view2);
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$5(this.f$0, view2);
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$6(this.f$0, view2);
            }
        });
        ImageButton imageButton11 = this.btnPaste;
        if (imageButton11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPaste");
            imageButton11 = null;
        }
        imageButton11.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$7(this.f$0, view2);
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$8(this.f$0, view2);
            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$9(this.f$0, view2);
            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.onCreate$lambda$10(this.f$0, imageButton10, view2);
            }
        });
        View.OnKeyListener onKeyListener = new View.OnKeyListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return MainActivity.onCreate$lambda$11(this.f$0, view2, i, keyEvent);
            }
        };
        ImageButton[] imageButtonArr = new ImageButton[11];
        ImageButton imageButton12 = this.btnBack;
        if (imageButton12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageButton12 = null;
        }
        imageButtonArr[0] = imageButton12;
        ImageButton imageButton13 = this.btnForward;
        if (imageButton13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnForward");
            imageButton13 = null;
        }
        imageButtonArr[1] = imageButton13;
        imageButtonArr[2] = imageButton3;
        imageButtonArr[3] = imageButton4;
        imageButtonArr[4] = imageButton5;
        imageButtonArr[5] = imageButton6;
        imageButtonArr[6] = imageButton7;
        ImageButton imageButton14 = this.btnPaste;
        if (imageButton14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPaste");
            imageButton14 = null;
        }
        imageButtonArr[7] = imageButton14;
        imageButtonArr[8] = imageButton8;
        imageButtonArr[9] = imageButton9;
        imageButtonArr[10] = imageButton10;
        Iterator it = CollectionsKt.listOf((Object[]) imageButtonArr).iterator();
        while (it.hasNext()) {
            ((ImageButton) it.next()).setOnKeyListener(onKeyListener);
        }
        observeVm();
        if (hasPerms()) {
            initNav();
        } else {
            requestPerms();
        }
        ListView listView4 = this.listView;
        if (listView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        } else {
            listView = listView4;
        }
        listView.post(new Runnable() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.onCreate$lambda$12(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.goBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.goForward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        fileExplorerViewModel.navigateTo(absolutePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.clearSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.copySelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.cutSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$7(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.paste();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$8(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = this$0.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.deleteSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$9(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showAddMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$10(MainActivity this$0, ImageButton imageButton, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(imageButton);
        this$0.showOverflowMenu(imageButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$11(MainActivity this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (keyEvent.getAction() != 0 || i != 20) {
            return false;
        }
        View view2 = this$0.focusAnchor;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusAnchor");
            view2 = null;
        }
        view2.requestFocus();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$12(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.focusAnchor;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusAnchor");
            view = null;
        }
        view.requestFocus();
    }

    private final void observeVm() {
        FileExplorerViewModel fileExplorerViewModel = this.vm;
        FileExplorerViewModel fileExplorerViewModel2 = null;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.getUiState().observe(new Function1<UiState, Unit>() { // from class: com.fileexplorer.ui.MainActivity.observeVm.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UiState uiState) {
                invoke2(uiState);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UiState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                FileAdapter fileAdapter = MainActivity.this.adapter;
                ImageButton imageButton = null;
                if (fileAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    fileAdapter = null;
                }
                fileAdapter.setItems(state.getFiles());
                FileAdapter fileAdapter2 = MainActivity.this.adapter;
                if (fileAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    fileAdapter2 = null;
                }
                fileAdapter2.setSelected(state.getSelectedFiles());
                FileAdapter fileAdapter3 = MainActivity.this.adapter;
                if (fileAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    fileAdapter3 = null;
                }
                fileAdapter3.setFocusedIndex(state.getFocusedIndex());
                ProgressBar progressBar = MainActivity.this.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(state.isLoading() ? 0 : 8);
                View view = MainActivity.this.emptyView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyView");
                    view = null;
                }
                view.setVisibility((!state.getFiles().isEmpty() || state.isLoading()) ? 8 : 0);
                TextView textView = MainActivity.this.breadcrumb;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
                    textView = null;
                }
                textView.setText(state.getCurrentPath());
                ImageButton imageButton2 = MainActivity.this.btnBack;
                if (imageButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnBack");
                    imageButton2 = null;
                }
                FileExplorerViewModel fileExplorerViewModel3 = MainActivity.this.vm;
                if (fileExplorerViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel3 = null;
                }
                imageButton2.setEnabled(fileExplorerViewModel3.getCanGoBack());
                ImageButton imageButton3 = MainActivity.this.btnForward;
                if (imageButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnForward");
                    imageButton3 = null;
                }
                FileExplorerViewModel fileExplorerViewModel4 = MainActivity.this.vm;
                if (fileExplorerViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel4 = null;
                }
                imageButton3.setEnabled(fileExplorerViewModel4.getCanGoForward());
                if (!state.getSelectedFiles().isEmpty()) {
                    View view2 = MainActivity.this.selectionBar;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectionBar");
                        view2 = null;
                    }
                    view2.setVisibility(0);
                    TextView textView2 = MainActivity.this.selectionCount;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectionCount");
                        textView2 = null;
                    }
                    textView2.setText(state.getSelectedFiles().size() + " נבחרו");
                    ActionBar actionBar = MainActivity.this.getActionBar();
                    if (actionBar != null) {
                        actionBar.setTitle(state.getSelectedFiles().size() + " נבחרו");
                    }
                    ImageButton imageButton4 = MainActivity.this.btnPaste;
                    if (imageButton4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnPaste");
                    } else {
                        imageButton = imageButton4;
                    }
                    imageButton.setVisibility(state.getClipboardFiles().isEmpty() ^ true ? 0 : 8);
                } else {
                    View view3 = MainActivity.this.selectionBar;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectionBar");
                        view3 = null;
                    }
                    view3.setVisibility(8);
                    ActionBar actionBar2 = MainActivity.this.getActionBar();
                    if (actionBar2 != null) {
                        String name = new File(state.getCurrentPath()).getName();
                        if (name.length() == 0) {
                            name = "סייר קבצים";
                        }
                        actionBar2.setTitle(name);
                    }
                    ImageButton imageButton5 = MainActivity.this.btnPaste;
                    if (imageButton5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnPaste");
                    } else {
                        imageButton = imageButton5;
                    }
                    imageButton.setVisibility(8);
                }
                String error = state.getError();
                if (error != null) {
                    Toast.makeText(MainActivity.this, error, 0).show();
                }
            }
        });
        FileExplorerViewModel fileExplorerViewModel3 = this.vm;
        if (fileExplorerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            fileExplorerViewModel2 = fileExplorerViewModel3;
        }
        fileExplorerViewModel2.getEvents().observe(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.fileexplorer.ui.MainActivity$observeVm$2, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "event", "Lcom/fileexplorer/ui/FileEvent;", "invoke"}, k = Base64.bytesPerGroup, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function1<FileEvent, Unit> {
        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FileEvent fileEvent) {
            invoke2(fileEvent);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final FileEvent fileEvent) {
            if (fileEvent == null) {
                return;
            }
            FileExplorerViewModel fileExplorerViewModel = null;
            if (fileEvent instanceof FileEvent.ShowMessage) {
                Toast.makeText(MainActivity.this, ((FileEvent.ShowMessage) fileEvent).getMessage(), 0).show();
                FileExplorerViewModel fileExplorerViewModel2 = MainActivity.this.vm;
                if (fileExplorerViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel = fileExplorerViewModel2;
                }
                fileExplorerViewModel.eventHandled();
                return;
            }
            if (fileEvent instanceof FileEvent.ShowError) {
                Toast.makeText(MainActivity.this, ((FileEvent.ShowError) fileEvent).getError(), 1).show();
                FileExplorerViewModel fileExplorerViewModel3 = MainActivity.this.vm;
                if (fileExplorerViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel = fileExplorerViewModel3;
                }
                fileExplorerViewModel.eventHandled();
                return;
            }
            if (fileEvent instanceof FileEvent.AskConfirm) {
                FileEvent.AskConfirm askConfirm = (FileEvent.AskConfirm) fileEvent;
                new AlertDialog.Builder(MainActivity.this).setTitle(askConfirm.getTitle()).setMessage(askConfirm.getMessage()).setPositiveButton("כן", new DialogInterface.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$observeVm$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.AnonymousClass2.invoke$lambda$0(fileEvent, dialogInterface, i);
                    }
                }).setNegativeButton("ביטול", (DialogInterface.OnClickListener) null).show();
                FileExplorerViewModel fileExplorerViewModel4 = MainActivity.this.vm;
                if (fileExplorerViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel = fileExplorerViewModel4;
                }
                fileExplorerViewModel.eventHandled();
                return;
            }
            if (fileEvent instanceof FileEvent.OpenFile) {
                MainActivity.this.openFile(((FileEvent.OpenFile) fileEvent).getFile());
                FileExplorerViewModel fileExplorerViewModel5 = MainActivity.this.vm;
                if (fileExplorerViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel = fileExplorerViewModel5;
                }
                fileExplorerViewModel.eventHandled();
                return;
            }
            if (fileEvent instanceof FileEvent.ShowDetails) {
                MainActivity.this.showDetailsDialog(((FileEvent.ShowDetails) fileEvent).getDetails());
                FileExplorerViewModel fileExplorerViewModel6 = MainActivity.this.vm;
                if (fileExplorerViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel = fileExplorerViewModel6;
                }
                fileExplorerViewModel.eventHandled();
                return;
            }
            if (fileEvent instanceof FileEvent.AskInput) {
                FileEvent.AskInput askInput = (FileEvent.AskInput) fileEvent;
                MainActivity.this.showInputDialog(askInput.getTitle(), askInput.getHint(), askInput.getPrefill(), askInput.getAction());
                FileExplorerViewModel fileExplorerViewModel7 = MainActivity.this.vm;
                if (fileExplorerViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel = fileExplorerViewModel7;
                }
                fileExplorerViewModel.eventHandled();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(FileEvent fileEvent, DialogInterface dialogInterface, int i) {
            ((FileEvent.AskConfirm) fileEvent).getAction().invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleClick(FileItem item, int pos) {
        FileExplorerViewModel fileExplorerViewModel = this.vm;
        FileExplorerViewModel fileExplorerViewModel2 = null;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.setFocusedIndex(pos);
        FileExplorerViewModel fileExplorerViewModel3 = this.vm;
        if (fileExplorerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel3 = null;
        }
        if (fileExplorerViewModel3.isSelectionMode()) {
            FileExplorerViewModel fileExplorerViewModel4 = this.vm;
            if (fileExplorerViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                fileExplorerViewModel2 = fileExplorerViewModel4;
            }
            fileExplorerViewModel2.toggleSelection(item.getPath());
            return;
        }
        FileExplorerViewModel fileExplorerViewModel5 = this.vm;
        if (fileExplorerViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            fileExplorerViewModel2 = fileExplorerViewModel5;
        }
        fileExplorerViewModel2.onItemActivated(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleLongClick(FileItem item, int pos) {
        FileExplorerViewModel fileExplorerViewModel = this.vm;
        FileExplorerViewModel fileExplorerViewModel2 = null;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.setFocusedIndex(pos);
        FileExplorerViewModel fileExplorerViewModel3 = this.vm;
        if (fileExplorerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            fileExplorerViewModel2 = fileExplorerViewModel3;
        }
        fileExplorerViewModel2.toggleSelection(item.getPath());
        return true;
    }

    private final int gridColumnCount() {
        GridView gridView = this.gridView;
        GridView gridView2 = null;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridView");
            gridView = null;
        }
        int width = gridView.getWidth();
        if (width <= 0) {
            return 3;
        }
        float f = getResources().getDisplayMetrics().density;
        int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (84 * f), 1);
        int i = (int) (2 * f);
        GridView gridView3 = this.gridView;
        if (gridView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridView");
            gridView3 = null;
        }
        int paddingLeft = gridView3.getPaddingLeft();
        GridView gridView4 = this.gridView;
        if (gridView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridView");
        } else {
            gridView2 = gridView4;
        }
        return RangesKt.coerceAtLeast(RangesKt.coerceAtLeast((width - (paddingLeft + gridView2.getPaddingRight())) + i, iCoerceAtLeast) / (iCoerceAtLeast + i), 1);
    }

    private final boolean moveFocus(int idx) {
        FileAdapter fileAdapter = this.adapter;
        ListView listView = null;
        GridView gridView = null;
        if (fileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fileAdapter = null;
        }
        int count = fileAdapter.getCount();
        if (count == 0) {
            return false;
        }
        int iCoerceIn = RangesKt.coerceIn(idx, 0, count - 1);
        FileExplorerViewModel fileExplorerViewModel = this.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.setFocusedIndex(iCoerceIn);
        FileExplorerViewModel fileExplorerViewModel2 = this.vm;
        if (fileExplorerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel2 = null;
        }
        if (fileExplorerViewModel2.getViewMode() == ViewMode.GRID) {
            GridView gridView2 = this.gridView;
            if (gridView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridView");
            } else {
                gridView = gridView2;
            }
            gridView.smoothScrollToPosition(iCoerceIn);
        } else {
            ListView listView2 = this.listView;
            if (listView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            } else {
                listView = listView2;
            }
            listView.smoothScrollToPosition(iCoerceIn);
        }
        return true;
    }

    private final void updateViewModeVisibility() {
        FileExplorerViewModel fileExplorerViewModel = this.vm;
        ListView listView = null;
        GridView gridView = null;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        if (fileExplorerViewModel.getViewMode() == ViewMode.GRID) {
            ListView listView2 = this.listView;
            if (listView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                listView2 = null;
            }
            listView2.setVisibility(8);
            GridView gridView2 = this.gridView;
            if (gridView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridView");
            } else {
                gridView = gridView2;
            }
            gridView.setVisibility(0);
            return;
        }
        GridView gridView3 = this.gridView;
        if (gridView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridView");
            gridView3 = null;
        }
        gridView3.setVisibility(8);
        ListView listView3 = this.listView;
        if (listView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            listView = listView3;
        }
        listView.setVisibility(0);
    }

    private final boolean isListFocused() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            View view = this.focusAnchor;
            GridView gridView = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusAnchor");
                view = null;
            }
            if (currentFocus != view) {
                ListView listView = this.listView;
                if (listView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    listView = null;
                }
                if (currentFocus != listView) {
                    GridView gridView2 = this.gridView;
                    if (gridView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gridView");
                    } else {
                        gridView = gridView2;
                    }
                    if (currentFocus != gridView) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:161:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:162:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:164:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:167:0x0203 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:170:0x0208  */
    /* JADX WARN: Code duplicated, block: B:176:0x0218  */
    /* JADX WARN: Code duplicated, block: B:180:0x0227  */
    /* JADX WARN: Code duplicated, block: B:181:0x022b  */
    /* JADX WARN: Code duplicated, block: B:183:0x0231 A[DONT_INVERT, FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:184:0x0233 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:185:0x0234  */
    /* JADX WARN: Code duplicated, block: B:187:0x023a  */
    /* JADX WARN: Code duplicated, block: B:189:0x023e  */
    /* JADX WARN: Code duplicated, block: B:193:0x0249  */
    /* JADX WARN: Code duplicated, block: B:195:0x024d  */
    /* JADX WARN: Code duplicated, block: B:196:0x0251  */
    /* JADX WARN: Code duplicated, block: B:198:0x0257  */
    /* JADX WARN: Code duplicated, block: B:200:0x025b  */
    /* JADX WARN: Code duplicated, block: B:201:0x025f  */
    private final boolean handleListKey(KeyEvent ev) {
        FileExplorerViewModel fileExplorerViewModel;
        FileExplorerViewModel fileExplorerViewModel2;
        FileExplorerViewModel fileExplorerViewModel3;
        FileExplorerViewModel fileExplorerViewModel4;
        FileExplorerViewModel fileExplorerViewModel5;
        FileExplorerViewModel fileExplorerViewModel6;
        FileExplorerViewModel fileExplorerViewModel7;
        FileExplorerViewModel fileExplorerViewModel8 = this.vm;
        FileExplorerViewModel fileExplorerViewModel9 = null;
        FileExplorerViewModel fileExplorerViewModel10 = null;
        FileExplorerViewModel fileExplorerViewModel11 = null;
        FileExplorerViewModel fileExplorerViewModel12 = null;
        FileExplorerViewModel fileExplorerViewModel13 = null;
        FileExplorerViewModel fileExplorerViewModel14 = null;
        FileExplorerViewModel fileExplorerViewModel15 = null;
        FileExplorerViewModel fileExplorerViewModel16 = null;
        FileExplorerViewModel fileExplorerViewModel17 = null;
        FileExplorerViewModel fileExplorerViewModel18 = null;
        FileExplorerViewModel fileExplorerViewModel19 = null;
        FileExplorerViewModel fileExplorerViewModel20 = null;
        ImageButton imageButton = null;
        FileAdapter fileAdapter = null;
        FileExplorerViewModel fileExplorerViewModel21 = null;
        FileExplorerViewModel fileExplorerViewModel22 = null;
        if (fileExplorerViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel8 = null;
        }
        UiState value = fileExplorerViewModel8.getUiState().getValue();
        int focusedIndex = value.getFocusedIndex();
        FileItem fileItem = (FileItem) CollectionsKt.getOrNull(value.getFiles(), focusedIndex);
        FileExplorerViewModel fileExplorerViewModel23 = this.vm;
        if (fileExplorerViewModel23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel23 = null;
        }
        boolean z = fileExplorerViewModel23.getViewMode() == ViewMode.GRID;
        int iGridColumnCount = z ? gridColumnCount() : 1;
        int keyCode = ev.getKeyCode();
        if (keyCode != 66) {
            if (keyCode != 67) {
                if (keyCode == 92) {
                    return moveFocus(focusedIndex - (iGridColumnCount * 5));
                }
                if (keyCode == 93) {
                    return moveFocus(focusedIndex + (iGridColumnCount * 5));
                }
                if (keyCode == 122) {
                    return moveFocus(0);
                }
                if (keyCode == 123) {
                    FileAdapter fileAdapter2 = this.adapter;
                    if (fileAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        fileAdapter = fileAdapter2;
                    }
                    return moveFocus(fileAdapter.getCount() - 1);
                }
                switch (keyCode) {
                    case 19:
                        int i = focusedIndex - iGridColumnCount;
                        if (i >= 0) {
                            return moveFocus(i);
                        }
                        ImageButton imageButton2 = this.btnBack;
                        if (imageButton2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
                        } else {
                            imageButton = imageButton2;
                        }
                        imageButton.requestFocus();
                        break;
                        break;
                    case 20:
                        return moveFocus(focusedIndex + iGridColumnCount);
                    case 21:
                        if (z) {
                            return moveFocus(focusedIndex - 1);
                        }
                        FileExplorerViewModel fileExplorerViewModel24 = this.vm;
                        if (fileExplorerViewModel24 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("vm");
                        } else {
                            fileExplorerViewModel20 = fileExplorerViewModel24;
                        }
                        fileExplorerViewModel20.goBack();
                        break;
                    case 22:
                        if (z) {
                            return moveFocus(focusedIndex + 1);
                        }
                        if (fileItem == null || !fileItem.isDirectory()) {
                            return false;
                        }
                        FileExplorerViewModel fileExplorerViewModel25 = this.vm;
                        if (fileExplorerViewModel25 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("vm");
                        } else {
                            fileExplorerViewModel19 = fileExplorerViewModel25;
                        }
                        fileExplorerViewModel19.onItemActivated(fileItem);
                        break;
                        break;
                    default:
                        switch (keyCode) {
                            case 29:
                                if (!ev.isCtrlPressed()) {
                                    return false;
                                }
                                FileExplorerViewModel fileExplorerViewModel26 = this.vm;
                                if (fileExplorerViewModel26 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel18 = fileExplorerViewModel26;
                                }
                                fileExplorerViewModel18.selectAll();
                                break;
                                break;
                            case 31:
                                if (!ev.isCtrlPressed()) {
                                    return false;
                                }
                                if (fileItem == null) {
                                    FileExplorerViewModel fileExplorerViewModel27 = this.vm;
                                    if (fileExplorerViewModel27 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                                        fileExplorerViewModel27 = null;
                                    }
                                    if (!fileExplorerViewModel27.isSelectionMode()) {
                                        return false;
                                    }
                                }
                                FileExplorerViewModel fileExplorerViewModel28 = this.vm;
                                if (fileExplorerViewModel28 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                    fileExplorerViewModel28 = null;
                                }
                                if (!fileExplorerViewModel28.isSelectionMode() && fileItem != null) {
                                    FileExplorerViewModel fileExplorerViewModel29 = this.vm;
                                    if (fileExplorerViewModel29 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                                        fileExplorerViewModel29 = null;
                                    }
                                    fileExplorerViewModel29.toggleSelection(fileItem.getPath());
                                }
                                FileExplorerViewModel fileExplorerViewModel30 = this.vm;
                                if (fileExplorerViewModel30 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel17 = fileExplorerViewModel30;
                                }
                                fileExplorerViewModel17.copySelected();
                                break;
                                break;
                            case 37:
                                if (!ev.isCtrlPressed() || fileItem == null) {
                                    return false;
                                }
                                FileExplorerViewModel fileExplorerViewModel31 = this.vm;
                                if (fileExplorerViewModel31 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel16 = fileExplorerViewModel31;
                                }
                                fileExplorerViewModel16.showDetails(fileItem);
                                break;
                            case 46:
                                if (!ev.isCtrlPressed()) {
                                    return false;
                                }
                                FileExplorerViewModel fileExplorerViewModel32 = this.vm;
                                if (fileExplorerViewModel32 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel15 = fileExplorerViewModel32;
                                }
                                fileExplorerViewModel15.refresh();
                                break;
                                break;
                            case 50:
                                if (!ev.isCtrlPressed()) {
                                    return false;
                                }
                                FileExplorerViewModel fileExplorerViewModel33 = this.vm;
                                if (fileExplorerViewModel33 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel14 = fileExplorerViewModel33;
                                }
                                fileExplorerViewModel14.paste();
                                break;
                                break;
                            case 52:
                                if (!ev.isCtrlPressed()) {
                                    return false;
                                }
                                if (fileItem == null) {
                                    FileExplorerViewModel fileExplorerViewModel34 = this.vm;
                                    if (fileExplorerViewModel34 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                                        fileExplorerViewModel34 = null;
                                    }
                                    if (!fileExplorerViewModel34.isSelectionMode()) {
                                        return false;
                                    }
                                }
                                FileExplorerViewModel fileExplorerViewModel35 = this.vm;
                                if (fileExplorerViewModel35 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                    fileExplorerViewModel35 = null;
                                }
                                if (!fileExplorerViewModel35.isSelectionMode() && fileItem != null) {
                                    FileExplorerViewModel fileExplorerViewModel36 = this.vm;
                                    if (fileExplorerViewModel36 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                                        fileExplorerViewModel36 = null;
                                    }
                                    fileExplorerViewModel36.toggleSelection(fileItem.getPath());
                                }
                                FileExplorerViewModel fileExplorerViewModel37 = this.vm;
                                if (fileExplorerViewModel37 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel13 = fileExplorerViewModel37;
                                }
                                fileExplorerViewModel13.cutSelected();
                                break;
                                break;
                            case 62:
                                if (fileItem == null) {
                                    return false;
                                }
                                FileExplorerViewModel fileExplorerViewModel38 = this.vm;
                                if (fileExplorerViewModel38 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel12 = fileExplorerViewModel38;
                                }
                                fileExplorerViewModel12.toggleSelection(fileItem.getPath());
                                break;
                            case 112:
                                if (fileItem == null) {
                                    fileExplorerViewModel7 = this.vm;
                                    if (fileExplorerViewModel7 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                                        fileExplorerViewModel7 = null;
                                    }
                                    if (!fileExplorerViewModel7.isSelectionMode()) {
                                        return false;
                                    }
                                }
                                fileExplorerViewModel4 = this.vm;
                                if (fileExplorerViewModel4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                    fileExplorerViewModel4 = null;
                                }
                                if (!fileExplorerViewModel4.isSelectionMode()) {
                                    fileExplorerViewModel6 = this.vm;
                                    if (fileExplorerViewModel6 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                                        fileExplorerViewModel6 = null;
                                    }
                                    fileExplorerViewModel6.toggleSelection(fileItem.getPath());
                                }
                                fileExplorerViewModel5 = this.vm;
                                if (fileExplorerViewModel5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel21 = fileExplorerViewModel5;
                                }
                                fileExplorerViewModel21.deleteSelected();
                                break;
                            case 132:
                                if (fileItem == null) {
                                    return false;
                                }
                                FileExplorerViewModel fileExplorerViewModel39 = this.vm;
                                if (fileExplorerViewModel39 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel11 = fileExplorerViewModel39;
                                }
                                fileExplorerViewModel11.renameFile(fileItem);
                                break;
                            case 135:
                                FileExplorerViewModel fileExplorerViewModel40 = this.vm;
                                if (fileExplorerViewModel40 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel10 = fileExplorerViewModel40;
                                }
                                fileExplorerViewModel10.refresh();
                                break;
                            case 160:
                                break;
                            default:
                                return false;
                        }
                    case 23:
                        if (fileItem == null) {
                            return false;
                        }
                        if (!ev.isShiftPressed()) {
                            fileExplorerViewModel2 = this.vm;
                            if (fileExplorerViewModel2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("vm");
                                fileExplorerViewModel2 = null;
                            }
                            if (!fileExplorerViewModel2.isSelectionMode()) {
                                fileExplorerViewModel3 = this.vm;
                                if (fileExplorerViewModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel22 = fileExplorerViewModel3;
                                }
                                fileExplorerViewModel22.onItemActivated(fileItem);
                            } else {
                                fileExplorerViewModel = this.vm;
                                if (fileExplorerViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                } else {
                                    fileExplorerViewModel9 = fileExplorerViewModel;
                                }
                                fileExplorerViewModel9.toggleSelection(fileItem.getPath());
                            }
                        } else {
                            fileExplorerViewModel = this.vm;
                            if (fileExplorerViewModel == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("vm");
                            } else {
                                fileExplorerViewModel9 = fileExplorerViewModel;
                            }
                            fileExplorerViewModel9.toggleSelection(fileItem.getPath());
                        }
                        break;
                }
            } else {
                if (fileItem == null) {
                    fileExplorerViewModel7 = this.vm;
                    if (fileExplorerViewModel7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        fileExplorerViewModel7 = null;
                    }
                    if (!fileExplorerViewModel7.isSelectionMode()) {
                        return false;
                    }
                }
                fileExplorerViewModel4 = this.vm;
                if (fileExplorerViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel4 = null;
                }
                if (!fileExplorerViewModel4.isSelectionMode() && fileItem != null) {
                    fileExplorerViewModel6 = this.vm;
                    if (fileExplorerViewModel6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        fileExplorerViewModel6 = null;
                    }
                    fileExplorerViewModel6.toggleSelection(fileItem.getPath());
                }
                fileExplorerViewModel5 = this.vm;
                if (fileExplorerViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel21 = fileExplorerViewModel5;
                }
                fileExplorerViewModel21.deleteSelected();
            }
        } else {
            if (fileItem == null) {
                return false;
            }
            if (!ev.isShiftPressed()) {
                fileExplorerViewModel = this.vm;
                if (fileExplorerViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel9 = fileExplorerViewModel;
                }
                fileExplorerViewModel9.toggleSelection(fileItem.getPath());
            } else {
                fileExplorerViewModel2 = this.vm;
                if (fileExplorerViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel2 = null;
                }
                if (!fileExplorerViewModel2.isSelectionMode()) {
                    fileExplorerViewModel = this.vm;
                    if (fileExplorerViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                    } else {
                        fileExplorerViewModel9 = fileExplorerViewModel;
                    }
                    fileExplorerViewModel9.toggleSelection(fileItem.getPath());
                } else {
                    fileExplorerViewModel3 = this.vm;
                    if (fileExplorerViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                    } else {
                        fileExplorerViewModel22 = fileExplorerViewModel3;
                    }
                    fileExplorerViewModel22.onItemActivated(fileItem);
                }
            }
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 0) {
            return super.dispatchKeyEvent(event);
        }
        int keyCode = event.getKeyCode();
        FileExplorerViewModel fileExplorerViewModel = null;
        FileExplorerViewModel fileExplorerViewModel2 = null;
        View view = null;
        FileExplorerViewModel fileExplorerViewModel3 = null;
        if (keyCode == 4) {
            FileExplorerViewModel fileExplorerViewModel4 = this.vm;
            if (fileExplorerViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                fileExplorerViewModel4 = null;
            }
            if (fileExplorerViewModel4.isSelectionMode()) {
                FileExplorerViewModel fileExplorerViewModel5 = this.vm;
                if (fileExplorerViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    fileExplorerViewModel3 = fileExplorerViewModel5;
                }
                fileExplorerViewModel3.clearSelection();
                return true;
            }
            FileExplorerViewModel fileExplorerViewModel6 = this.vm;
            if (fileExplorerViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                fileExplorerViewModel = fileExplorerViewModel6;
            }
            if (fileExplorerViewModel.goBack()) {
                return true;
            }
            return super.dispatchKeyEvent(event);
        }
        if (keyCode == 61) {
            int i = event.isShiftPressed() ? 1 : 2;
            View currentFocus = getCurrentFocus();
            if (currentFocus == null && (currentFocus = this.focusAnchor) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusAnchor");
            } else {
                view = currentFocus;
            }
            View viewFocusSearch = view.focusSearch(i);
            if (viewFocusSearch != null) {
                viewFocusSearch.requestFocus();
                return true;
            }
        } else {
            if (keyCode == 82) {
                View viewFindViewById = findViewById(R.id.btnMore);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                showOverflowMenu(viewFindViewById);
                return true;
            }
            if (keyCode == 84) {
                openOptionsMenu();
                return true;
            }
            if (keyCode == 111) {
                FileExplorerViewModel fileExplorerViewModel7 = this.vm;
                if (fileExplorerViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel7 = null;
                }
                if (fileExplorerViewModel7.isSelectionMode()) {
                    FileExplorerViewModel fileExplorerViewModel8 = this.vm;
                    if (fileExplorerViewModel8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                    } else {
                        fileExplorerViewModel2 = fileExplorerViewModel8;
                    }
                    fileExplorerViewModel2.clearSelection();
                    return true;
                }
            }
        }
        if (isListFocused() && handleListKey(event)) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.action_search);
        View actionView = menuItemFindItem != null ? menuItemFindItem.getActionView() : null;
        SearchView searchView = actionView instanceof SearchView ? (SearchView) actionView : null;
        if (searchView != null) {
            searchView.setQueryHint("חפש קבצים...");
        }
        if (searchView == null) {
            return true;
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.fileexplorer.ui.MainActivity.onCreateOptionsMenu.1
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String q) {
                Intrinsics.checkNotNullParameter(q, "q");
                FileExplorerViewModel fileExplorerViewModel = MainActivity.this.vm;
                if (fileExplorerViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel = null;
                }
                fileExplorerViewModel.search(q);
                return true;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String t) {
                Intrinsics.checkNotNullParameter(t, "t");
                if (t.length() != 0) {
                    return true;
                }
                FileExplorerViewModel fileExplorerViewModel = MainActivity.this.vm;
                if (fileExplorerViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel = null;
                }
                fileExplorerViewModel.refresh();
                return true;
            }
        });
        return true;
    }

    private final void showAddMenu() {
        new AlertDialog.Builder(this).setTitle("צור חדש").setItems(new String[]{"תיקייה חדשה", "קובץ חדש"}, new DialogInterface.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showAddMenu$lambda$13(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAddMenu$lambda$13(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileExplorerViewModel fileExplorerViewModel = null;
        FileExplorerViewModel fileExplorerViewModel2 = this$0.vm;
        if (i == 0) {
            if (fileExplorerViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                fileExplorerViewModel = fileExplorerViewModel2;
            }
            fileExplorerViewModel.createFolder();
            return;
        }
        if (fileExplorerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            fileExplorerViewModel = fileExplorerViewModel2;
        }
        fileExplorerViewModel.createFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInputDialog(String title, String hint, String prefill, final Function1<? super String, Unit> action) {
        MainActivity mainActivity = this;
        final EditText editText = new EditText(mainActivity);
        editText.setHint(hint);
        editText.setText(prefill);
        editText.selectAll();
        editText.setSingleLine();
        int i = (int) (16 * editText.getResources().getDisplayMetrics().density);
        editText.setPadding(i, i, i, i);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(mainActivity).setTitle(title).setView(editText).setPositiveButton("אישור", new DialogInterface.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MainActivity.showInputDialog$lambda$15(action, editText, dialogInterface, i2);
            }
        }).setNegativeButton("ביטול", (DialogInterface.OnClickListener) null).create();
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda18
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return MainActivity.showInputDialog$lambda$16(action, editText, alertDialogCreate, textView, i2, keyEvent);
            }
        });
        alertDialogCreate.show();
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInputDialog$lambda$15(Function1 action, EditText input, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(input, "$input");
        action.invoke(input.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showInputDialog$lambda$16(Function1 action, EditText input, AlertDialog alertDialog, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(input, "$input");
        if (i != 6) {
            return false;
        }
        action.invoke(input.getText().toString());
        alertDialog.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDetailsDialog(Map<String, String> details) {
        new AlertDialog.Builder(this).setTitle("פרטי קובץ").setMessage(CollectionsKt.joinToString$default(details.entrySet(), "\n", null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends String>, CharSequence>() { // from class: com.fileexplorer.ui.MainActivity$showDetailsDialog$msg$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getKey() + ": " + it.getValue();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
                return invoke2((Map.Entry<String, String>) entry);
            }
        }, 30, null)).setPositiveButton("סגור", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:46:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00fe  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void openFile(File file) {
        String mimeTypeFromExtension;
        try {
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String lowerCase = StringsKt.substringAfterLast(name, ".", "").toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case 3479:
                    if (!lowerCase.equals("md")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "text/plain";
                    }
                    break;
                case 52316:
                    if (!lowerCase.equals("3gp")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "video/mp4";
                    }
                    break;
                case 96323:
                    if (!lowerCase.equals("aac")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "audio/mpeg";
                    }
                    break;
                case 96796:
                    if (!lowerCase.equals("apk")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "application/vnd.android.package-archive";
                    }
                    break;
                case 102340:
                    if (!lowerCase.equals("gif")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "image/gif";
                    }
                    break;
                case 103649:
                    if (!lowerCase.equals("htm")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "text/html";
                    }
                    break;
                case 105441:
                    if (!lowerCase.equals("jpg")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "image/jpeg";
                    }
                    break;
                case 107332:
                    if (!lowerCase.equals("log")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "text/plain";
                    }
                    break;
                case 108272:
                    if (!lowerCase.equals("mp3")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "audio/mpeg";
                    }
                    break;
                case 108273:
                    if (!lowerCase.equals("mp4")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "video/mp4";
                    }
                    break;
                case 109967:
                    if (!lowerCase.equals("ogg")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "audio/mpeg";
                    }
                    break;
                case 110834:
                    if (!lowerCase.equals("pdf")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "application/pdf";
                    }
                    break;
                case 111145:
                    if (!lowerCase.equals("png")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "image/png";
                    }
                    break;
                case 115312:
                    if (!lowerCase.equals("txt")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "text/plain";
                    }
                    break;
                case 118807:
                    if (!lowerCase.equals("xml")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "text/xml";
                    }
                    break;
                case 120609:
                    if (!lowerCase.equals("zip")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "application/zip";
                    }
                    break;
                case 3213227:
                    if (!lowerCase.equals("html")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "text/html";
                    }
                    break;
                case 3268712:
                    if (!lowerCase.equals("jpeg")) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        if (mimeTypeFromExtension == null) {
                            mimeTypeFromExtension = "*/*";
                        }
                    } else {
                        mimeTypeFromExtension = "image/jpeg";
                    }
                    break;
                default:
                    mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                    if (mimeTypeFromExtension == null) {
                        mimeTypeFromExtension = "*/*";
                    }
                    break;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setDataAndType(AppFileProvider.INSTANCE.getUriForFile(file), mimeTypeFromExtension);
                intent.addFlags(1);
                intent.addFlags(2);
            } else {
                intent.setDataAndType(Uri.fromFile(file), mimeTypeFromExtension);
            }
            intent.addFlags(268435456);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "אין אפליקציה לפתוח קובץ זה", 0).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "שגיאה: " + e.getMessage(), 0).show();
        }
    }

    private final void initNav() {
        FileExplorerViewModel fileExplorerViewModel = this.vm;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        fileExplorerViewModel.navigateTo(absolutePath);
    }

    private final boolean hasPerms() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
        }
        // Below API 23: permissions are granted at install time, no runtime check exists.
        return true;
    }

    private final void requestPerms() {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                startActivityForResult(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + getPackageName())), this.PERM_REQ);
                return;
            } catch (Exception unused) {
                startActivityForResult(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"), this.PERM_REQ);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, this.PERM_REQ);
            return;
        }
        // Below API 23: nothing to request; permission was already granted at install time.
        initNav();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int req, String[] perms, int[] grants) {
        Intrinsics.checkNotNullParameter(perms, "perms");
        Intrinsics.checkNotNullParameter(grants, "grants");
        super.onRequestPermissionsResult(req, perms, grants);
        if (req == this.PERM_REQ) {
            if ((!(grants.length == 0)) && grants[0] == 0) {
                initNav();
                return;
            }
        }
        Toast.makeText(this, "נדרשת הרשאה לגישה לקבצים", 1).show();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int req, int res, Intent data) {
        super.onActivityResult(req, res, data);
        if (req == this.PERM_REQ && hasPerms()) {
            initNav();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/fileexplorer/ui/MainActivity$PopupRow;", "", "icon", "", "text", "", "checked", "", "action", "Lkotlin/Function0;", "", "(ILjava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "getChecked", "()Z", "getIcon", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static final /* data */ class PopupRow {
        private final Function0<Unit> action;
        private final boolean checked;
        private final int icon;
        private final String text;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PopupRow copy$default(PopupRow popupRow, int i, String str, boolean z, Function0 function0, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = popupRow.icon;
            }
            if ((i2 & 2) != 0) {
                str = popupRow.text;
            }
            if ((i2 & 4) != 0) {
                z = popupRow.checked;
            }
            if ((i2 & 8) != 0) {
                function0 = popupRow.action;
            }
            return popupRow.copy(i, str, z, function0);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIcon() {
            return this.icon;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getChecked() {
            return this.checked;
        }

        public final Function0<Unit> component4() {
            return this.action;
        }

        public final PopupRow copy(int icon, String text, boolean checked, Function0<Unit> action) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(action, "action");
            return new PopupRow(icon, text, checked, action);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PopupRow)) {
                return false;
            }
            PopupRow popupRow = (PopupRow) other;
            return this.icon == popupRow.icon && Intrinsics.areEqual(this.text, popupRow.text) && this.checked == popupRow.checked && Intrinsics.areEqual(this.action, popupRow.action);
        }

        public final Function0<Unit> getAction() {
            return this.action;
        }

        public final boolean getChecked() {
            return this.checked;
        }

        public final int getIcon() {
            return this.icon;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return (((((this.icon * 31) + this.text.hashCode()) * 31) + FileItem$$ExternalSyntheticBackport0.m(this.checked)) * 31) + this.action.hashCode();
        }

        public String toString() {
            return "PopupRow(icon=" + this.icon + ", text=" + this.text + ", checked=" + this.checked + ", action=" + this.action + ')';
        }

        public PopupRow(int i, String text, boolean z, Function0<Unit> action) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(action, "action");
            this.icon = i;
            this.text = text;
            this.checked = z;
            this.action = action;
        }

        public /* synthetic */ PopupRow(int i, String str, boolean z, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? false : z, function0);
        }
    }

    private final void showPopupMenu(View anchor, List<PopupRow> rows) {
        MainActivity mainActivity = this;
        View viewInflate = LayoutInflater.from(mainActivity).inflate(R.layout.popup_menu, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        final LinearLayout linearLayout = (LinearLayout) viewInflate;
        final PopupWindow popupWindow = new PopupWindow((View) linearLayout, -2, -2, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        int i = 0;
        for (Object obj : rows) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final PopupRow popupRow = (PopupRow) obj;
            View viewInflate2 = LayoutInflater.from(mainActivity).inflate(R.layout.popup_menu_item, (ViewGroup) linearLayout, false);
            ((ImageView) viewInflate2.findViewById(R.id.itemIcon)).setImageResource(popupRow.getIcon());
            ((TextView) viewInflate2.findViewById(R.id.itemText)).setText(popupRow.getText());
            ((ImageView) viewInflate2.findViewById(R.id.itemCheck)).setVisibility(popupRow.getChecked() ? 0 : 8);
            viewInflate2.setFocusable(true);
            viewInflate2.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.showPopupMenu$lambda$20$lambda$17(popupWindow, popupRow, view);
                }
            });
            viewInflate2.setOnKeyListener(new View.OnKeyListener() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda14
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                    return MainActivity.showPopupMenu$lambda$20$lambda$18(view, i3, keyEvent);
                }
            });
            linearLayout.addView(viewInflate2);
            if (i < rows.size() - 1) {
                View view = new View(mainActivity);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                layoutParams.leftMargin = 14;
                layoutParams.rightMargin = 14;
                view.setLayoutParams(layoutParams);
                view.setBackgroundResource(R.drawable.popup_divider);
                linearLayout.addView(view);
            }
            i = i2;
        }
        popupWindow.showAsDropDown(anchor, -160, 4);
        linearLayout.post(new Runnable() { // from class: com.fileexplorer.ui.MainActivity$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.showPopupMenu$lambda$21(linearLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupMenu$lambda$20$lambda$17(PopupWindow popup, PopupRow row, View view) {
        Intrinsics.checkNotNullParameter(popup, "$popup");
        Intrinsics.checkNotNullParameter(row, "$row");
        popup.dismiss();
        row.getAction().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPopupMenu$lambda$20$lambda$18(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || (i != 66 && i != 23)) {
            return false;
        }
        view.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupMenu$lambda$21(LinearLayout container) {
        Intrinsics.checkNotNullParameter(container, "$container");
        if (container.getChildCount() > 0) {
            container.getChildAt(0).requestFocus();
        }
    }

    private final void showOverflowMenu(final View anchor) {
        FileExplorerViewModel fileExplorerViewModel = this.vm;
        FileExplorerViewModel fileExplorerViewModel2 = null;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        UiState value = fileExplorerViewModel.getUiState().getValue();
        PopupRow[] popupRowArr = new PopupRow[5];
        FileExplorerViewModel fileExplorerViewModel3 = this.vm;
        if (fileExplorerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel3 = null;
        }
        popupRowArr[0] = fileExplorerViewModel3.getViewMode() == ViewMode.GRID ? new PopupRow(R.drawable.ic_view_list, "תצוגת רשימה", false, new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity$showOverflowMenu$rows$1
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
                this.this$0.switchViewMode();
            }
        }, 4, null) : new PopupRow(R.drawable.ic_view_grid, "תצוגת רשת", false, new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity$showOverflowMenu$rows$2
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
                this.this$0.switchViewMode();
            }
        }, 4, null);
        popupRowArr[1] = new PopupRow(R.drawable.ic_sort, "מיון", false, new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity$showOverflowMenu$rows$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                this.this$0.showSortPopup(anchor);
            }
        }, 4, null);
        FileExplorerViewModel fileExplorerViewModel4 = this.vm;
        if (fileExplorerViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            fileExplorerViewModel2 = fileExplorerViewModel4;
        }
        popupRowArr[2] = new PopupRow(R.drawable.ic_eye, "קבצים מוסתרים", fileExplorerViewModel2.getShowHidden(), new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity$showOverflowMenu$rows$4
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
                FileExplorerViewModel fileExplorerViewModel5 = this.this$0.vm;
                if (fileExplorerViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel5 = null;
                }
                fileExplorerViewModel5.toggleHidden();
            }
        });
        boolean z = false;
        int i = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        popupRowArr[3] = new PopupRow(R.drawable.ic_sdcard, "בחר אחסון", z, new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity$showOverflowMenu$rows$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                this.this$0.showStoragePopup(anchor);
            }
        }, i, defaultConstructorMarker);
        popupRowArr[4] = new PopupRow(R.drawable.ic_refresh, "רענן", z, new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity$showOverflowMenu$rows$6
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
                FileExplorerViewModel fileExplorerViewModel5 = this.this$0.vm;
                if (fileExplorerViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    fileExplorerViewModel5 = null;
                }
                fileExplorerViewModel5.refresh();
            }
        }, i, defaultConstructorMarker);
        List<PopupRow> listMutableListOf = CollectionsKt.mutableListOf(popupRowArr);
        if (!value.getClipboardFiles().isEmpty()) {
            listMutableListOf.add(1, new PopupRow(R.drawable.ic_paste, "הדבק", false, new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity.showOverflowMenu.1
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
                    FileExplorerViewModel fileExplorerViewModel5 = MainActivity.this.vm;
                    if (fileExplorerViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        fileExplorerViewModel5 = null;
                    }
                    fileExplorerViewModel5.paste();
                }
            }, 4, null));
        }
        showPopupMenu(anchor, listMutableListOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchViewMode() {
        FileExplorerViewModel fileExplorerViewModel = this.vm;
        FileExplorerViewModel fileExplorerViewModel2 = null;
        if (fileExplorerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            fileExplorerViewModel = null;
        }
        fileExplorerViewModel.toggleViewMode();
        FileAdapter fileAdapter = this.adapter;
        if (fileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fileAdapter = null;
        }
        FileExplorerViewModel fileExplorerViewModel3 = this.vm;
        if (fileExplorerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            fileExplorerViewModel2 = fileExplorerViewModel3;
        }
        fileAdapter.setViewMode(fileExplorerViewModel2.getViewMode());
        updateViewModeVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSortPopup(View anchor) {
        List<Pair> listListOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("שם (א → ת)", SortOrder.NAME_ASC), TuplesKt.to("שם (ת → א)", SortOrder.NAME_DESC), TuplesKt.to("גודל (גדול ← קטן)", SortOrder.SIZE_DESC), TuplesKt.to("תאריך (חדש ← ישן)", SortOrder.DATE_DESC), TuplesKt.to("סוג קובץ", SortOrder.TYPE_ASC)});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        for (Pair pair : listListOf) {
            String str = (String) pair.component1();
            final SortOrder sortOrder = (SortOrder) pair.component2();
            FileExplorerViewModel fileExplorerViewModel = this.vm;
            if (fileExplorerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                fileExplorerViewModel = null;
            }
            arrayList.add(new PopupRow(R.drawable.ic_sort, str, fileExplorerViewModel.getSortOrder() == sortOrder, new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity$showSortPopup$rows$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    FileExplorerViewModel fileExplorerViewModel2 = this.this$0.vm;
                    if (fileExplorerViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        fileExplorerViewModel2 = null;
                    }
                    fileExplorerViewModel2.setSortOrder(sortOrder);
                }
            }));
        }
        showPopupMenu(anchor, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStoragePopup(View anchor) {
        List<Pair<String, String>> rootPaths = FileRepository.INSTANCE.getRootPaths();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(rootPaths, 10));
        Iterator<T> it = rootPaths.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.component1();
            final String str2 = (String) pair.component2();
            FileExplorerViewModel fileExplorerViewModel = this.vm;
            if (fileExplorerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                fileExplorerViewModel = null;
            }
            arrayList.add(new PopupRow(R.drawable.ic_sdcard, str, Intrinsics.areEqual(fileExplorerViewModel.getCurrentPath(), str2), new Function0<Unit>() { // from class: com.fileexplorer.ui.MainActivity$showStoragePopup$rows$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    FileExplorerViewModel fileExplorerViewModel2 = this.this$0.vm;
                    if (fileExplorerViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        fileExplorerViewModel2 = null;
                    }
                    fileExplorerViewModel2.navigateTo(str2);
                }
            }));
        }
        showPopupMenu(anchor, arrayList);
    }
}
