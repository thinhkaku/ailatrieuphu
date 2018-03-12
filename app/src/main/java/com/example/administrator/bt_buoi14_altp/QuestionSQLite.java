package com.example.administrator.bt_buoi14_altp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 9/22/2017.
 */

public class QuestionSQLite {
    public static final String PATH = Environment.getDataDirectory().getPath()+"/data/com.example.administrator.bt_buoi14_altp/database/";
    public static final String  DB_NAME = "Question.sqlite";
    public static final String  DB_NAME1 = "nhapmoncongnghephanmem.sqlite";
    public static final String  TABLE_NAME1 = "SELECT * FROM Question1  order by random() limit 1";
    public static final String  TABLE_NAME2 = "SELECT * FROM Question2  order by random() limit 1";
    public static final String  TABLE_NAME3 = "SELECT * FROM Question3  order by random() limit 1";
    public static final String  TABLE_NAME4 = "SELECT * FROM Question4  order by random() limit 1";
    public static final String  TABLE_NAME5 = "SELECT * FROM Question5  order by random() limit 1";
    public static final String  TABLE_NAME6 = "SELECT * FROM Question6  order by random() limit 1";
    public static final String  TABLE_NAME7 = "SELECT * FROM Question7  order by random() limit 1";
    public static final String  TABLE_NAME8 = "SELECT * FROM Question8  order by random() limit 1";
    public static final String  TABLE_NAME9 = "SELECT * FROM Question9  order by random() limit 1";
    public static final String  TABLE_NAME10 = "SELECT * FROM Question10  order by random() limit 1";
    public static final String  TABLE_NAME11 = "SELECT * FROM Question11  order by random() limit 1";
    public static final String  TABLE_NAME12 = "SELECT * FROM Question12  order by random() limit 1";
    public static final String  TABLE_NAME13 = "SELECT * FROM Question13  order by random() limit 1";
    public static final String  TABLE_NAME14 = "SELECT * FROM Question14  order by random() limit 1";
    public static final String  TABLE_NAME15 = "SELECT * FROM Question15  order by random() limit 1";
    public static final String  TABLE_NAME16 = "SELECT * FROM Question1  order by random() limit 1";
    public static final String  ID = "id";
    public static final String  QUESTION = "Question";
    public static final String  CASEA = "CaseA";
    public static final String  CASEB = "CaseB";
    public static final String  CASEC = "CaseC";
    public static final String  CASED = "CaseD";
    public static final String  TRUECASE = "TrueCase";

    private Context context;
    private SQLiteDatabase database;


    public QuestionSQLite(Context context){
        this.context = context;
        copyDatabaseToProject();
    }
    private void  copyDatabaseToProject(){
        try {
            File file = new File(PATH+DB_NAME1);
            if (file.exists()){
                return;
            }
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = context.getAssets().open(DB_NAME1);
            byte []b= new byte[1024];
            int count = inputStream.read(b);
            while (count!=-1){
                fileOutputStream.write(b,0,count);
                count= inputStream.read(b);
            }
            fileOutputStream.close();
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void openDataBase(){
        database = context.openOrCreateDatabase(PATH+DB_NAME1,Context.MODE_PRIVATE,null);

    }
    public void closeDataBase(){
        database.close();
    }
    public  ArrayList<QuesTion> getDataQuestion16(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME1,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }

    public  ArrayList<QuesTion> getDataQuestion1(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME1,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion2(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME2,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion3(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME3,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion4(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME4,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion5(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME5,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion6(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME6,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion7(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME7,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion8(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME8,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion9(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME9,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion10(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME10,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion11(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME11,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion12(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME12,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion13(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME13,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion14(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME14,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }
    public  ArrayList<QuesTion> getDataQuestion15(){
        ArrayList<QuesTion> arrquestion1 = new ArrayList<>();
        openDataBase();
        Cursor cursor = database.rawQuery(TABLE_NAME15,null);
        int indexID = cursor.getColumnIndex(ID);
        int indexQuestion = cursor.getColumnIndex(QUESTION);
        int indexCaseA = cursor.getColumnIndex(CASEA);
        int indexCaseB = cursor.getColumnIndex(CASEB);
        int indexCaseC = cursor.getColumnIndex(CASEC);
        int indexCaseD = cursor.getColumnIndex(CASED);
        int indexTrueCase= cursor.getColumnIndex(TRUECASE);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            int id = cursor.getInt(indexID);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            QuesTion quesTion = new QuesTion(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrquestion1.add(quesTion);
            cursor.moveToNext();
        }
        closeDataBase();
        return arrquestion1;
    }

}
