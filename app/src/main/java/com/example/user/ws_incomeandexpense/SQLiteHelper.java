package com.example.user.ws_incomeandexpense;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SQLiteHelper extends SQLiteOpenHelper {
      private static final String DATABASE_NAME = "db_income_expense";
      private static final int VERSION = 1;
      private static SQLiteHelper sqliteHelper;

      private SQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
      }


      public static synchronized SQLiteHelper getInstance(Context c) {
            if(sqliteHelper == null) {
                  sqliteHelper = new SQLiteHelper(c.getApplicationContext());
            }
            return sqliteHelper;
      }

      @Override
      public void onCreate(SQLiteDatabase db) {
            String sql = 	"CREATE TABLE table_income_expense(" +
                                          "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                          "date INTEGER, " +
                                          "month INTEGER, " +
                                          "year INTEGER, " +
                                          "type TEXT, " +
                                          "title TEXT, " +
                                          "amount INTEGER)";

            db.execSQL(sql);
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
      }
}

