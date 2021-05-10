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

public class TournamentDuoDirections {
  private TournamentDuoDirections() {
  }

  @NonNull
  public static ActionFragmentTournamentToFragmentFilm actionFragmentTournamentToFragmentFilm(
      long filmId) {
    return new ActionFragmentTournamentToFragmentFilm(filmId);
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

  public static class ActionFragmentTournamentToFragmentFilm implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFragmentTournamentToFragmentFilm(long filmId) {
      this.arguments.put("filmId", filmId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFragmentTournamentToFragmentFilm setFilmId(long filmId) {
      this.arguments.put("filmId", filmId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("filmId")) {
        long filmId = (long) arguments.get("filmId");
        __result.putLong("filmId", filmId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_fragment_tournament_to_fragment_film;
    }

    @SuppressWarnings("unchecked")
    public long getFilmId() {
      return (long) arguments.get("filmId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFragmentTournamentToFragmentFilm that = (ActionFragmentTournamentToFragmentFilm) object;
      if (arguments.containsKey("filmId") != that.arguments.containsKey("filmId")) {
        return false;
      }
      if (getFilmId() != that.getFilmId()) {
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
      result = 31 * result + (int)(getFilmId() ^ (getFilmId() >>> 32));
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFragmentTournamentToFragmentFilm(actionId=" + getActionId() + "){"
          + "filmId=" + getFilmId()
          + "}";
    }
  }
}
