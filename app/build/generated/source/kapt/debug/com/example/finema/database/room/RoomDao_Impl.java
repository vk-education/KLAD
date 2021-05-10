package com.example.finema.database.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.finema.models.databaseModels.GenreModel;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDao_Impl implements RoomDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GenreModel> __insertionAdapterOfGenreModel;

  public RoomDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGenreModel = new EntityInsertionAdapter<GenreModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `genre_list` (`id`,`name`,`image`,`idFirebase`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GenreModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getImage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindBlob(3, value.getImage());
        }
        if (value.getIdFirebase() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIdFirebase());
        }
      }
    };
  }

  @Override
  public Object insert(final GenreModel note, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGenreModel.insert(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<GenreModel>> getAllGenres() {
    final String _sql = "SELECT * FROM genre_list";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"genre_list"}, false, new Callable<List<GenreModel>>() {
      @Override
      public List<GenreModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfIdFirebase = CursorUtil.getColumnIndexOrThrow(_cursor, "idFirebase");
          final List<GenreModel> _result = new ArrayList<GenreModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GenreModel _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final byte[] _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getBlob(_cursorIndexOfImage);
            }
            final String _tmpIdFirebase;
            if (_cursor.isNull(_cursorIndexOfIdFirebase)) {
              _tmpIdFirebase = null;
            } else {
              _tmpIdFirebase = _cursor.getString(_cursorIndexOfIdFirebase);
            }
            _item = new GenreModel(_tmpId,_tmpName,_tmpImage,_tmpIdFirebase);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
