package it.wakala.talkrepo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "comics_table")
 class ComicsTable : Serializable{

    @PrimaryKey(autoGenerate = true)
    var internalIdComics: Long = 0

    @ColumnInfo(name = "id_comics")
    var idComics: Int? = null

    @ColumnInfo(name = "digital_id")
    var digitalID:Int? = null

    @ColumnInfo(name = "title")
    var title:String? = null

    @ColumnInfo(name = "variant_description")
    var variantDescription:String? = null

    @ColumnInfo(name = "description")
    var description:String? = null

    @ColumnInfo(name = "page_count")
    var pageCount:Int? = null

    @ColumnInfo(name = "resource_uri")
    var resourceURI:String? = null

    @ColumnInfo(name = "thumbnail_path")
    var thumbnailPath:String? = null

   @ColumnInfo(name = "thumbnail_extension")
   var thumbnailExtension:String? = null

 }