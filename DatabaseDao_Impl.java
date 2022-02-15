package com.example.aplikasitokoonline.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.aplikasitokoonline.model.ModelDatabase;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseDao_Impl implements DatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ModelDatabase> __insertionAdapterOfModelDatabase;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSingleData;

  public DatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModelDatabase = new EntityInsertionAdapter<ModelDatabase>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tbl_banksampah` (`uid`,`nama_pengguna`,`jenis_sampah`,`berat`,`harga`,`tanggal`,`alamat`,`catatan`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ModelDatabase value) {
        stmt.bindLong(1, value.getUid());
        if (value.getNamaPengguna() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNamaPengguna());
        }
        if (value.getJenisSampah() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getJenisSampah());
        }
        stmt.bindLong(4, value.getBerat());
        stmt.bindLong(5, value.getHarga());
        if (value.getTanggal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTanggal());
        }
        if (value.getAlamat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAlamat());
        }
        if (value.getCatatan() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCatatan());
        }
      }
    };
    this.__preparedStmtOfDeleteSingleData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tbl_banksampah WHERE uid= ?";
        return _query;
      }
    };
  }

  @Override
  public void insertData(final ModelDatabase modelDatabases) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfModelDatabase.insert(modelDatabases);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSingleData(final int uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSingleData.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, uid);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSingleData.release(_stmt);
    }
  }

  @Override
  public LiveData<List<ModelDatabase>> getAll() {
    final String _sql = "SELECT * FROM tbl_banksampah";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_banksampah"}, false, new Callable<List<ModelDatabase>>() {
      @Override
      public List<ModelDatabase> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfNamaPengguna = CursorUtil.getColumnIndexOrThrow(_cursor, "nama_pengguna");
          final int _cursorIndexOfJenisSampah = CursorUtil.getColumnIndexOrThrow(_cursor, "jenis_sampah");
          final int _cursorIndexOfBerat = CursorUtil.getColumnIndexOrThrow(_cursor, "berat");
          final int _cursorIndexOfHarga = CursorUtil.getColumnIndexOrThrow(_cursor, "harga");
          final int _cursorIndexOfTanggal = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggal");
          final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
          final int _cursorIndexOfCatatan = CursorUtil.getColumnIndexOrThrow(_cursor, "catatan");
          final List<ModelDatabase> _result = new ArrayList<ModelDatabase>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ModelDatabase _item;
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            final String _tmpNamaPengguna;
            if (_cursor.isNull(_cursorIndexOfNamaPengguna)) {
              _tmpNamaPengguna = null;
            } else {
              _tmpNamaPengguna = _cursor.getString(_cursorIndexOfNamaPengguna);
            }
            final String _tmpJenisSampah;
            if (_cursor.isNull(_cursorIndexOfJenisSampah)) {
              _tmpJenisSampah = null;
            } else {
              _tmpJenisSampah = _cursor.getString(_cursorIndexOfJenisSampah);
            }
            final int _tmpBerat;
            _tmpBerat = _cursor.getInt(_cursorIndexOfBerat);
            final int _tmpHarga;
            _tmpHarga = _cursor.getInt(_cursorIndexOfHarga);
            final String _tmpTanggal;
            if (_cursor.isNull(_cursorIndexOfTanggal)) {
              _tmpTanggal = null;
            } else {
              _tmpTanggal = _cursor.getString(_cursorIndexOfTanggal);
            }
            final String _tmpAlamat;
            if (_cursor.isNull(_cursorIndexOfAlamat)) {
              _tmpAlamat = null;
            } else {
              _tmpAlamat = _cursor.getString(_cursorIndexOfAlamat);
            }
            final String _tmpCatatan;
            if (_cursor.isNull(_cursorIndexOfCatatan)) {
              _tmpCatatan = null;
            } else {
              _tmpCatatan = _cursor.getString(_cursorIndexOfCatatan);
            }
            _item = new ModelDatabase(_tmpUid,_tmpNamaPengguna,_tmpJenisSampah,_tmpBerat,_tmpHarga,_tmpTanggal,_tmpAlamat,_tmpCatatan);
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

  @Override
  public LiveData<Integer> getSaldo() {
    final String _sql = "SELECT SUM(harga) FROM tbl_banksampah";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_banksampah"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
