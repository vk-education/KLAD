package com.example.finema.ui.movieDetail;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MovieDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MovieDetailsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private MovieDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MovieDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    MovieDetailsFragmentArgs __result = new MovieDetailsFragmentArgs();
    bundle.setClassLoader(MovieDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("filmId")) {
      long filmId;
      filmId = bundle.getLong("filmId");
      __result.arguments.put("filmId", filmId);
    } else {
      throw new IllegalArgumentException("Required argument \"filmId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public long getFilmId() {
    return (long) arguments.get("filmId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("filmId")) {
      long filmId = (long) arguments.get("filmId");
      __result.putLong("filmId", filmId);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    MovieDetailsFragmentArgs that = (MovieDetailsFragmentArgs) object;
    if (arguments.containsKey("filmId") != that.arguments.containsKey("filmId")) {
      return false;
    }
    if (getFilmId() != that.getFilmId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (int)(getFilmId() ^ (getFilmId() >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "MovieDetailsFragmentArgs{"
        + "filmId=" + getFilmId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(MovieDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(long filmId) {
      this.arguments.put("filmId", filmId);
    }

    @NonNull
    public MovieDetailsFragmentArgs build() {
      MovieDetailsFragmentArgs result = new MovieDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setFilmId(long filmId) {
      this.arguments.put("filmId", filmId);
      return this;
    }

    @SuppressWarnings("unchecked")
    public long getFilmId() {
      return (long) arguments.get("filmId");
    }
  }
}
