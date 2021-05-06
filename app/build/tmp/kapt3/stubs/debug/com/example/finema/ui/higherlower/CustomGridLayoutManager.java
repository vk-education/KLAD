package com.example.finema.ui.higherlower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/example/finema/ui/higherlower/CustomGridLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isScrollEnabled", "", "()Z", "setScrollEnabled", "(Z)V", "canScrollVertically", "app_debug"})
public final class CustomGridLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    private boolean isScrollEnabled = false;
    
    public final boolean isScrollEnabled() {
        return false;
    }
    
    public final void setScrollEnabled(boolean p0) {
    }
    
    @java.lang.Override()
    public boolean canScrollVertically() {
        return false;
    }
    
    public CustomGridLayoutManager(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
}