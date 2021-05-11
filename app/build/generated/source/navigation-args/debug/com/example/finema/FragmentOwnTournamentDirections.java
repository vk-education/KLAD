package com.example.finema;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FragmentOwnTournamentDirections {
  private FragmentOwnTournamentDirections() {
  }

  @NonNull
  public static ActionFragmentOwnTournamentToFragmentTournament actionFragmentOwnTournamentToFragmentTournament(
      int number) {
    return new ActionFragmentOwnTournamentToFragmentTournament(number);
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

  public static class ActionFragmentOwnTournamentToFragmentTournament implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFragmentOwnTournamentToFragmentTournament(int number) {
      this.arguments.put("number", number);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFragmentOwnTournamentToFragmentTournament setNumber(int number) {
      this.arguments.put("number", number);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("number")) {
        int number = (int) arguments.get("number");
        __result.putInt("number", number);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_fragment_own_tournament_to_fragment_tournament;
    }

    @SuppressWarnings("unchecked")
    public int getNumber() {
      return (int) arguments.get("number");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFragmentOwnTournamentToFragmentTournament that = (ActionFragmentOwnTournamentToFragmentTournament) object;
      if (arguments.containsKey("number") != that.arguments.containsKey("number")) {
        return false;
      }
      if (getNumber() != that.getNumber()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getNumber();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFragmentOwnTournamentToFragmentTournament(actionId=" + getActionId() + "){"
          + "number=" + getNumber()
          + "}";
    }
  }
}
