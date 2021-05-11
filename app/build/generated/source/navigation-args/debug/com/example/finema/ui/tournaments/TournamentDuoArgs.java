package com.example.finema.ui.tournaments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class TournamentDuoArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private TournamentDuoArgs() {
  }

  @SuppressWarnings("unchecked")
  private TournamentDuoArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TournamentDuoArgs fromBundle(@NonNull Bundle bundle) {
    TournamentDuoArgs __result = new TournamentDuoArgs();
    bundle.setClassLoader(TournamentDuoArgs.class.getClassLoader());
    if (bundle.containsKey("number")) {
      int number;
      number = bundle.getInt("number");
      __result.arguments.put("number", number);
    } else {
      throw new IllegalArgumentException("Required argument \"number\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getNumber() {
    return (int) arguments.get("number");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("number")) {
      int number = (int) arguments.get("number");
      __result.putInt("number", number);
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
    TournamentDuoArgs that = (TournamentDuoArgs) object;
    if (arguments.containsKey("number") != that.arguments.containsKey("number")) {
      return false;
    }
    if (getNumber() != that.getNumber()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getNumber();
    return result;
  }

  @Override
  public String toString() {
    return "TournamentDuoArgs{"
        + "number=" + getNumber()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(TournamentDuoArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(int number) {
      this.arguments.put("number", number);
    }

    @NonNull
    public TournamentDuoArgs build() {
      TournamentDuoArgs result = new TournamentDuoArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setNumber(int number) {
      this.arguments.put("number", number);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getNumber() {
      return (int) arguments.get("number");
    }
  }
}
