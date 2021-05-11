package com.example.finema;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FragmentFavouriteDirections {
  private FragmentFavouriteDirections() {
  }

  @NonNull
  public static ActionFragmentFavouriteToFragmentFilm actionFragmentFavouriteToFragmentFilm(
      long filmId) {
    return new ActionFragmentFavouriteToFragmentFilm(filmId);
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

  public static class ActionFragmentFavouriteToFragmentFilm implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFragmentFavouriteToFragmentFilm(long filmId) {
      this.arguments.put("filmId", filmId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFragmentFavouriteToFragmentFilm setFilmId(long filmId) {
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
      return R.id.action_fragmentFavourite_to_fragmentFilm;
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
      ActionFragmentFavouriteToFragmentFilm that = (ActionFragmentFavouriteToFragmentFilm) object;
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
      return "ActionFragmentFavouriteToFragmentFilm(actionId=" + getActionId() + "){"
          + "filmId=" + getFilmId()
          + "}";
    }
  }
}
