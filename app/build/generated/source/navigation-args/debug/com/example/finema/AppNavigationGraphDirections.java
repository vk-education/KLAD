package com.example.finema;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class AppNavigationGraphDirections {
  private AppNavigationGraphDirections() {
  }

  @NonNull
  public static NavDirections actionGlobalFragmentSettings() {
    return new ActionOnlyNavDirections(R.id.action_global_fragmentSettings);
  }

  @NonNull
  public static NavDirections actionGlobalFragmentProfile() {
    return new ActionOnlyNavDirections(R.id.action_global_fragmentProfile);
  }

  @NonNull
  public static NavDirections actionGlobalFragmentTmp() {
    return new ActionOnlyNavDirections(R.id.action_global_fragmentTmp);
  }

  @NonNull
  public static NavDirections actionGlobalSignIn() {
    return new ActionOnlyNavDirections(R.id.action_global_signIn);
  }

  @NonNull
  public static NavDirections actionGlobalFragmentFavourite() {
    return new ActionOnlyNavDirections(R.id.action_global_fragmentFavourite);
  }

  @NonNull
  public static NavDirections actionGlobalFragmentHigherLower() {
    return new ActionOnlyNavDirections(R.id.action_global_fragmentHigherLower);
  }
}
