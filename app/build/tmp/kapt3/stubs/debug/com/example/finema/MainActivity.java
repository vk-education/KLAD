package com.example.finema;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/finema/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "NOTIFICATION_CHANNEL_ID", "", "getNOTIFICATION_CHANNEL_ID", "()Ljava/lang/String;", "binding", "Lcom/example/finema/databinding/ActivityMainBinding;", "default_notification_channel_id", "service", "Landroid/content/Intent;", "getNotification", "Landroid/app/Notification;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "scheduleNotification", "notification", "delay", "", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String NOTIFICATION_CHANNEL_ID = "10001";
    private final java.lang.String default_notification_channel_id = "default";
    private com.example.finema.databinding.ActivityMainBinding binding;
    private android.content.Intent service;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNOTIFICATION_CHANNEL_ID() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void scheduleNotification(android.app.Notification notification, long delay) {
    }
    
    private final android.app.Notification getNotification() {
        return null;
    }
    
    public MainActivity() {
        super();
    }
}