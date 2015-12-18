package com.projects.ahmozz.myfirstgooglemapapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ahmozz on 14/12/15.
 */
    public class MyDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "MyDb.db";
        private static final java.lang.String SQL_CREATE_ENTRIES = "CREATE TABLE `pointCollecte` (" +
                "  `id_pointCollecte` INT NOT NULL ," +
                "  `name_pointCollecte` VARCHAR(45) NULL ," +
                "  `lat_pointCollecte` VARCHAR(45) NULL ," +
                "  `lng_pointCollecte` VARCHAR(45) NULL ," +
                "  `address_pointCollecte` VARCHAR(45) NULL ," +
                "  `capacity_pointCollecte` DOUBLE NULL ," +
                "  `availability_pointCollecte` DOUBLE NULL ," +
                "  `type_pointCollecte` VARCHAR(45) NULL,"+//SET('plastique', 'verre', 'metal', 'electronique', 'vetement') NULL ,\n" +
                "  PRIMARY KEY (`id_pointCollecte`) );"
                /*"ENGINE = InnoDB;"*/ +

                "CREATE TABLE `user` (" +
                "  `id_user` INT NOT NULL ," +
                "  `name_user` VARCHAR(45) NULL ," +
                "  `lastName_user` VARCHAR(45) NULL ," +
                "  `login_user` VARCHAR(45) NULL ," +
                "  `role_user` ENUM('membre', 'membreAdmin', 'admin') NULL ," +
                "  PRIMARY KEY (`id_user`) );" +
                /*"ENGINE = InnoDB;\n"*/

                "CREATE TABLE `collecte` (" +
                "  `id_collecte` INT NOT NULL ," +
                "  `date_collecte` VARCHAR(45) NULL ," +
                "  `user_id` INT NOT NULL ," +
                "  `pointCollecte_id` INT NOT NULL ," +
                "  PRIMARY KEY (`id_collecte`)  ," +
                "  INDEX `fk_collecte_1_idx` (`pointCollecte_id` ASC)  ," +
                "  INDEX `fk_collecte_2_idx` (`user_id` ASC)  ," +
                "  CONSTRAINT `fk_collecte_1`" +
                "    FOREIGN KEY (`pointCollecte_id`)" +
                "    REFERENCES `MyDb.db`.`pointCollecte` (`id_pointCollecte`)" +
                "    ON DELETE NO ACTION" +
                "    ON UPDATE NO ACTION," +
                "  CONSTRAINT `fk_collecte_2`" +
                "    FOREIGN KEY (`user_id`)" +
                "    REFERENCES `MyDb.db`.`user` (`id_user`)" +
                "    REFERENCES `MyDb.db`.`user` (`id_user`)" +
                "    ON DELETE NO ACTION" +
                "    ON UPDATE NO ACTION)";
                /*"ENGINE = InnoDB;\n" +

                "SET SQL_MODE=@OLD_SQL_MODE;\n" +
                "SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;\n" +
                "SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;";*/

        private static final java.lang.String SQL_DELETE_ENTRIES = "" ;

    public MyDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            //db.execSQL(SQL_DELETE_ENTRIES);
            //onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }