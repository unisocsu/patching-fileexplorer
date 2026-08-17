package com.fileexplorer.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileExplorerViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004"}, d2 = {"Lcom/fileexplorer/ui/Observable;", "T", "", "initial", "(Ljava/lang/Object;)V", "observers", "", "Lkotlin/Function1;", "", "v", "value", "getValue", "()Ljava/lang/Object;", "setValue", "Ljava/lang/Object;", "observe", "observer", "removeObserver"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Observable<T> {
    private final List<Function1<T, Unit>> observers = new ArrayList();
    private T value;

    public final T getValue() {
        return this.value;
    }

    public Observable(T t) {
        this.value = t;
    }

    public final void setValue(T t) {
        this.value = t;
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(t);
        }
    }

    public final void observe(Function1<? super T, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.add(observer);
        observer.invoke(this.value);
    }

    public final void removeObserver(Function1<? super T, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
    }
}
