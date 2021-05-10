// Generated by view binder compiler. Do not edit!
package com.example.finema.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.example.finema.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class NumberFragmentBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button btn128;

  @NonNull
  public final Button btn16;

  @NonNull
  public final Button btn256;

  @NonNull
  public final Button btn32;

  @NonNull
  public final Button btn64;

  @NonNull
  public final Button btn8;

  private NumberFragmentBinding(@NonNull CardView rootView, @NonNull Button btn128,
      @NonNull Button btn16, @NonNull Button btn256, @NonNull Button btn32, @NonNull Button btn64,
      @NonNull Button btn8) {
    this.rootView = rootView;
    this.btn128 = btn128;
    this.btn16 = btn16;
    this.btn256 = btn256;
    this.btn32 = btn32;
    this.btn64 = btn64;
    this.btn8 = btn8;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static NumberFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NumberFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.number_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NumberFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn128;
      Button btn128 = rootView.findViewById(id);
      if (btn128 == null) {
        break missingId;
      }

      id = R.id.btn16;
      Button btn16 = rootView.findViewById(id);
      if (btn16 == null) {
        break missingId;
      }

      id = R.id.btn256;
      Button btn256 = rootView.findViewById(id);
      if (btn256 == null) {
        break missingId;
      }

      id = R.id.btn32;
      Button btn32 = rootView.findViewById(id);
      if (btn32 == null) {
        break missingId;
      }

      id = R.id.btn64;
      Button btn64 = rootView.findViewById(id);
      if (btn64 == null) {
        break missingId;
      }

      id = R.id.btn8;
      Button btn8 = rootView.findViewById(id);
      if (btn8 == null) {
        break missingId;
      }

      return new NumberFragmentBinding((CardView) rootView, btn128, btn16, btn256, btn32, btn64,
          btn8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
