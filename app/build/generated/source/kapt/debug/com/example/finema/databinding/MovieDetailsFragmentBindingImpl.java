package com.example.finema.databinding;
import com.example.finema.R;
import com.example.finema.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MovieDetailsFragmentBindingImpl extends MovieDetailsFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 5);
        sViewsWithIds.put(R.id.layoutText, 6);
        sViewsWithIds.put(R.id.aboutTitle, 7);
        sViewsWithIds.put(R.id.genreTitle, 8);
        sViewsWithIds.put(R.id.ratingTitle, 9);
        sViewsWithIds.put(R.id.rating, 10);
        sViewsWithIds.put(R.id.companiesTitle, 11);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MovieDetailsFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private MovieDetailsFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[9]
            );
        this.companies.setTag(null);
        this.filmTitle.setTag(null);
        this.genres.setTag(null);
        this.layout.setTag(null);
        this.overview.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.filmId == variableId) {
            setFilmId((com.example.finema.models.movieResponse.MovieDetails) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFilmId(@Nullable com.example.finema.models.movieResponse.MovieDetails FilmId) {
        this.mFilmId = FilmId;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.filmId);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String filmIdTitle = null;
        java.lang.String filmIdOverview = null;
        java.lang.String filmIdStringGenres = null;
        com.example.finema.models.movieResponse.MovieDetails filmId = mFilmId;
        java.lang.String filmIdStringCompanies = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (filmId != null) {
                    // read filmId.title
                    filmIdTitle = filmId.getTitle();
                    // read filmId.overview
                    filmIdOverview = filmId.getOverview();
                    // read filmId.stringGenres
                    filmIdStringGenres = filmId.getStringGenres();
                    // read filmId.stringCompanies
                    filmIdStringCompanies = filmId.getStringCompanies();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.companies, filmIdStringCompanies);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.filmTitle, filmIdTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.genres, filmIdStringGenres);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.overview, filmIdOverview);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): filmId
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}