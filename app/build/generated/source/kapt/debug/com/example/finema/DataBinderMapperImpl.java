package com.example.finema;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.finema.databinding.FragmentBaseBindingImpl;
import com.example.finema.databinding.FragmentTournamentDuoBindingImpl;
import com.example.finema.databinding.FragmentTournamentGenresBindingImpl;
import com.example.finema.databinding.MovieDetailsFragmentBindingImpl;
import com.example.finema.databinding.MovieItemBindingImpl;
import com.example.finema.databinding.NavHeaderBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTBASE = 1;

  private static final int LAYOUT_FRAGMENTTOURNAMENTDUO = 2;

  private static final int LAYOUT_FRAGMENTTOURNAMENTGENRES = 3;

  private static final int LAYOUT_MOVIEDETAILSFRAGMENT = 4;

  private static final int LAYOUT_MOVIEITEM = 5;

  private static final int LAYOUT_NAVHEADER = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.finema.R.layout.fragment_base, LAYOUT_FRAGMENTBASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.finema.R.layout.fragment_tournament_duo, LAYOUT_FRAGMENTTOURNAMENTDUO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.finema.R.layout.fragment_tournament_genres, LAYOUT_FRAGMENTTOURNAMENTGENRES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.finema.R.layout.movie_details_fragment, LAYOUT_MOVIEDETAILSFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.finema.R.layout.movie_item, LAYOUT_MOVIEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.finema.R.layout.nav_header, LAYOUT_NAVHEADER);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTBASE: {
          if ("layout/fragment_base_0".equals(tag)) {
            return new FragmentBaseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_base is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTOURNAMENTDUO: {
          if ("layout/fragment_tournament_duo_0".equals(tag)) {
            return new FragmentTournamentDuoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_tournament_duo is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTOURNAMENTGENRES: {
          if ("layout/fragment_tournament_genres_0".equals(tag)) {
            return new FragmentTournamentGenresBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_tournament_genres is invalid. Received: " + tag);
        }
        case  LAYOUT_MOVIEDETAILSFRAGMENT: {
          if ("layout/movie_details_fragment_0".equals(tag)) {
            return new MovieDetailsFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for movie_details_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_MOVIEITEM: {
          if ("layout/movie_item_0".equals(tag)) {
            return new MovieItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for movie_item is invalid. Received: " + tag);
        }
        case  LAYOUT_NAVHEADER: {
          if ("layout/nav_header_0".equals(tag)) {
            return new NavHeaderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for nav_header is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "filmId");
      sKeys.put(2, "movie");
      sKeys.put(3, "nickname");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/fragment_base_0", com.example.finema.R.layout.fragment_base);
      sKeys.put("layout/fragment_tournament_duo_0", com.example.finema.R.layout.fragment_tournament_duo);
      sKeys.put("layout/fragment_tournament_genres_0", com.example.finema.R.layout.fragment_tournament_genres);
      sKeys.put("layout/movie_details_fragment_0", com.example.finema.R.layout.movie_details_fragment);
      sKeys.put("layout/movie_item_0", com.example.finema.R.layout.movie_item);
      sKeys.put("layout/nav_header_0", com.example.finema.R.layout.nav_header);
    }
  }
}
