package com.example.finema.ui.signIn;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/finema/ui/signIn/SignInViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "()V", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "activityResult", "", "data", "Landroid/content/Intent;", "firebaseAuthWithGoogle", "idToken", "", "signIn", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "Companion", "app_debug"})
public final class SignInViewModel extends com.example.finema.ui.base.BaseViewModel {
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 120;
    public static final com.example.finema.ui.signIn.SignInViewModel.Companion Companion = null;
    
    public final void signIn(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient) {
    }
    
    private final void activityResult(android.content.Intent data) {
    }
    
    private final void firebaseAuthWithGoogle(java.lang.String idToken) {
    }
    
    public SignInViewModel() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/finema/ui/signIn/SignInViewModel$Companion;", "", "()V", "RC_SIGN_IN", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}