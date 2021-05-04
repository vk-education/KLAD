package com.example.finema.ui.signIn;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/finema/ui/signIn/SignInViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mContext", "initDatabase", "", "type", "", "onSuccess", "Lkotlin/Function0;", "Companion", "app_debug"})
public final class SignInViewModel extends com.example.finema.ui.base.BaseViewModel {
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private final android.app.Application mContext = null;
    private static final int RC_SIGN_IN = 120;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.ui.signIn.SignInViewModel.Companion Companion = null;
    
    public final void initDatabase(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public SignInViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/finema/ui/signIn/SignInViewModel$Companion;", "", "()V", "RC_SIGN_IN", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}