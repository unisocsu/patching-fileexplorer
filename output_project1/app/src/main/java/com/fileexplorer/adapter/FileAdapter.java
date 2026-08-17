package com.fileexplorer.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.fileexplorer.R;
import com.fileexplorer.model.FileItem;
import com.fileexplorer.model.FileType;
import com.fileexplorer.model.ViewMode;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0006\u0010\u001a\u001a\u00020\tJ\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020%H\u0016J\u000e\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\tJ\u0014\u0010(\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0*J\u0014\u0010+\u001a\u00020\n2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160-J\u000e\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000"}, d2 = {"Lcom/fileexplorer/adapter/FileAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "viewMode", "Lcom/fileexplorer/model/ViewMode;", "onItemClick", "Lkotlin/Function2;", "Lcom/fileexplorer/model/FileItem;", "", "", "onItemLongClick", "", "(Landroid/content/Context;Lcom/fileexplorer/model/ViewMode;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "focusedIndex", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "items", "", "selectedPaths", "", "", "getChipColor", "item", "getCount", "getFocusedIndex", "getIconRes", "getItem", "pos", "getItemId", "", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "setFocusedIndex", "index", "setItems", "newItems", "", "setSelected", "paths", "", "setViewMode", "mode"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileAdapter extends BaseAdapter {
    private final Context context;
    private int focusedIndex;
    private final LayoutInflater inflater;
    private final List<FileItem> items;
    private final Function2<FileItem, Integer, Unit> onItemClick;
    private final Function2<FileItem, Integer, Boolean> onItemLongClick;
    private Set<String> selectedPaths;
    private ViewMode viewMode;

    /* JADX INFO: compiled from: FileAdapter.kt */
    @Metadata(k = Base64.bytesPerGroup, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileType.values().length];
            try {
                iArr[FileType.FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileType.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileType.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileType.PDF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileType.WORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FileType.EXCEL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FileType.POWERPOINT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FileType.ARCHIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FileType.APK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FileType.TEXT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FileType.CODE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[FileType.UNKNOWN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final int getFocusedIndex() {
        return this.focusedIndex;
    }

    @Override // android.widget.Adapter
    public long getItemId(int pos) {
        return pos;
    }

    public /* synthetic */ FileAdapter(Context context, ViewMode viewMode, Function2 function2, Function2 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? ViewMode.LIST : viewMode, function2, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileAdapter(Context context, ViewMode viewMode, Function2<? super FileItem, ? super Integer, Unit> onItemClick, Function2<? super FileItem, ? super Integer, Boolean> onItemLongClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewMode, "viewMode");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onItemLongClick, "onItemLongClick");
        this.context = context;
        this.viewMode = viewMode;
        this.onItemClick = onItemClick;
        this.onItemLongClick = onItemLongClick;
        this.items = new ArrayList();
        this.selectedPaths = new LinkedHashSet();
        this.focusedIndex = -1;
        this.inflater = LayoutInflater.from(context);
    }

    public final void setItems(List<FileItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items.clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }

    public final void setSelected(Set<String> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        this.selectedPaths.clear();
        this.selectedPaths.addAll(paths);
        notifyDataSetChanged();
    }

    public final void setFocusedIndex(int index) {
        if (this.focusedIndex == index) {
            return;
        }
        this.focusedIndex = index;
        notifyDataSetChanged();
    }

    public final void setViewMode(ViewMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.viewMode = mode;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public FileItem getItem(int pos) {
        return this.items.get(pos);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        int i;
        Intrinsics.checkNotNullParameter(parent, "parent");
        int i2 = this.viewMode == ViewMode.LIST ? R.layout.item_file_list : R.layout.item_file_grid;
        if (convertView != null) {
            if (!Intrinsics.areEqual(convertView.getTag(), Integer.valueOf(i2))) {
                convertView = null;
            }
            if (convertView == null) {
                LayoutInflater layoutInflater = this.inflater;
                Intrinsics.checkNotNull(Integer.valueOf(i2), "null cannot be cast to non-null type kotlin.Int");
                convertView = layoutInflater.inflate(i2, parent, false);
                convertView.setTag(Integer.valueOf(i2));
            }
        } else {
            LayoutInflater layoutInflater2 = this.inflater;
            Intrinsics.checkNotNull(Integer.valueOf(i2), "null cannot be cast to non-null type kotlin.Int");
            convertView = layoutInflater2.inflate(i2, parent, false);
            convertView.setTag(Integer.valueOf(i2));
        }
        final FileItem fileItem = this.items.get(position);
        boolean zContains = this.selectedPaths.contains(fileItem.getPath());
        boolean z = position == this.focusedIndex;
        Object parent2 = convertView.findViewById(R.id.fileIcon).getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
        View view = (View) parent2;
        ImageView imageView = (ImageView) convertView.findViewById(R.id.fileIcon);
        TextView textView = (TextView) convertView.findViewById(R.id.fileName);
        TextView textView2 = (TextView) convertView.findViewById(R.id.fileDetail);
        TextView textView3 = (TextView) convertView.findViewById(R.id.fileSize);
        View viewFindViewById = convertView.findViewById(R.id.checkmark);
        textView.setText(fileItem.getName());
        if (textView2 != null) {
            textView2.setText(fileItem.getFormattedDate());
        }
        if (textView3 != null) {
            textView3.setText(fileItem.isDirectory() ? "תיקייה" : fileItem.getFormattedSize());
        }
        imageView.setImageResource(getIconRes(fileItem));
        view.setBackgroundResource(R.drawable.icon_chip);
        view.getBackground().mutate().setColorFilter(getChipColor(fileItem), PorterDuff.Mode.SRC_IN);
        if (z && zContains) {
            i = R.drawable.focused_selected_row_bg;
        } else if (z) {
            i = R.drawable.focused_row_bg;
        } else {
            i = zContains ? R.drawable.selected_row_bg : R.drawable.row_bg;
        }
        convertView.setBackgroundResource(i);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(zContains ? 0 : 8);
        }
        convertView.setFocusable(false);
        convertView.setOnClickListener(new View.OnClickListener() { // from class: com.fileexplorer.adapter.FileAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FileAdapter.getView$lambda$2(this.f$0, fileItem, position, view2);
            }
        });
        convertView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.fileexplorer.adapter.FileAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return FileAdapter.getView$lambda$3(this.f$0, fileItem, position, view2);
            }
        });
        Intrinsics.checkNotNull(convertView);
        return convertView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getView$lambda$2(FileAdapter this$0, FileItem item, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onItemClick.invoke(item, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getView$lambda$3(FileAdapter this$0, FileItem item, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        return this$0.onItemLongClick.invoke(item, Integer.valueOf(i)).booleanValue();
    }

    private final int getChipColor(FileItem item) {
        int i;
        Context context = this.context;
        switch (WhenMappings.$EnumSwitchMapping$0[item.getFileType().ordinal()]) {
            case 1:
                i = R.color.chip_folder;
                break;
            case 2:
                i = R.color.chip_image;
                break;
            case Base64.bytesPerGroup /* 3 */:
                i = R.color.chip_audio;
                break;
            case 4:
                i = R.color.chip_video;
                break;
            case 5:
                i = R.color.chip_pdf;
                break;
            case 6:
                i = R.color.chip_word;
                break;
            case 7:
                i = R.color.chip_excel;
                break;
            case 8:
                i = R.color.chip_ppt;
                break;
            case 9:
                i = R.color.chip_archive;
                break;
            case 10:
                i = R.color.chip_apk;
                break;
            case 11:
                i = R.color.chip_text;
                break;
            case 12:
                i = R.color.chip_code;
                break;
            case 13:
                i = R.color.chip_default;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return context.getResources().getColor(i);
    }

    private final int getIconRes(FileItem item) {
        switch (WhenMappings.$EnumSwitchMapping$0[item.getFileType().ordinal()]) {
            case 1:
                return R.drawable.ic_folder;
            case 2:
                return R.drawable.ic_image;
            case Base64.bytesPerGroup /* 3 */:
                return R.drawable.ic_audio;
            case 4:
                return R.drawable.ic_video;
            case 5:
                return R.drawable.ic_pdf;
            case 6:
                return R.drawable.ic_word;
            case 7:
                return R.drawable.ic_excel;
            case 8:
                return R.drawable.ic_powerpoint;
            case 9:
                return R.drawable.ic_archive;
            case 10:
                return R.drawable.ic_apk;
            case 11:
                return R.drawable.ic_text;
            case 12:
                return R.drawable.ic_code;
            case 13:
                return R.drawable.ic_file;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
