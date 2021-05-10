package com.example.finema.ui.tournaments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.finema.AppNavigationGraphDirections;
import com.example.finema.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class TournamentGenresFragmentDirections {
  private TournamentGenresFragmentDirections() {
  }

  @NonNull
  public static ActionFragmentGenreToFragmentTournament actionFragmentGenreToFragmentTournament(
      int number) {
    return new ActionFragmentGenreToFragmentTournament(number);
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

  public static class ActionFragmentGenreToFragmentTournament implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFragmentGenreToFragmentTournament(int number) {
      this.arguments.put("number", number);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFragmentGenreToFragmentTournament setNumber(int number) {
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
      return R.id.action_fragmentGenre_to_fragmentTournament;
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
      ActionFragmentGenreToFragmentTournament that = (ActionFragmentGenreToFragmentTournament) object;
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
      return "ActionFragmentGenreToFragmentTournament(actionId=" + getActionId() + "){"
          + "number=" + getNumber()
          + "}";
    }
  }
}
