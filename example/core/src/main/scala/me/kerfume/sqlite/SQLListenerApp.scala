package me.kerfume.sqlite

import antr.g4.sql._

class SQLListenerApp extends SQLiteBaseListener {

  override def enterParse(ctx: SQLiteParser.ParseContext): Unit = {
    println("parsing...")
    println(ctx.getText)
  }
  override def exitParse(ctx: SQLiteParser.ParseContext): Unit = {
    println("parsing...")
    println(ctx.getText)
  }
  override def enterSql_stmt(ctx: SQLiteParser.Sql_stmtContext): Unit = {
    println(ctx.getText)
    println(ctx.select_stmt().getText)
  }
}
