package com.example.finema.ui.signIn;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.finema.AppNavigationGraphDirections;
import com.example.finema.R;

public class SigInFragmentDirections {
  private SigInFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSigInFragmentToTmpFragment() {
    return new ActionOnlyNavDirections(R.id.action_sigInFragment_to_tmpFragment);
  }

  @NonNull
  public static NavDirections actionGlobalFragmentSettings() {
    return AppNavigationGraphDirections.actionGlobalFragmentSettings();
  }

  @NonNull
  public static NavDirections actionGlobalFragmentProfile() {
    return AppNavigationGraphDirections.actionGlobalFragmentProfile();
  }

  @NonNull
  public static NavDirections actionGlobalFragmentTmp() {
    return AppNavigationGraphDirections.actionGlobalFragmentTmp();
  }

  @NonNull
  public static NavDirections actionGlobalFragmentFavourite() {
    return AppNavigationGraphDirections.actionGlobalFragmentFavourite();
  }

  @NonNull
  public static NavDirections actionGlobalFragmentHigherLower() {
    return AppNavigationGraphDirections.actionGlobalFragmentHigherLower();
  }
}
