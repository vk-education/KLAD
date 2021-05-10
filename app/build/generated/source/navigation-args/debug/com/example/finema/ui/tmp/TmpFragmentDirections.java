package com.example.finema.ui.tmp;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.finema.AppNavigationGraphDirections;
import com.example.finema.R;

public class TmpFragmentDirections {
  private TmpFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionFragmentTmpToFragmentOthers() {
    return new ActionOnlyNavDirections(R.id.action_fragment_tmp_to_fragment_others);
  }

  @NonNull
  public static NavDirections actionFragmentTmpToFragmentGenre() {
    return new ActionOnlyNavDirections(R.id.action_fragment_tmp_to_fragment_genre);
  }

  @NonNull
  public static NavDirections actionFragmentTmpToFragmentOwnTournament() {
    return new ActionOnlyNavDirections(R.id.action_fragment_tmp_to_fragment_own_tournament);
  }

  @NonNull
  public static NavDirections actionTmpFragmentToSigInFragment() {
    return new ActionOnlyNavDirections(R.id.action_tmpFragment_to_sigInFragment);
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
