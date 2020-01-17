package me.kerfume

import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}

import scala.util.Try
//import a.g._

object Main extends App {
  println("hello.")

  def parseSQL(input: String) = {
    import antr.g4.sql._
    println("\nsql parse start to " + input)

    val charStream = new ANTLRInputStream(input)
    val lexer = new SQLiteLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new SQLiteParser(tokens)

    val arithmeticListener = new me.kerfume.sqlite.SQLListenerApp()
    /* Implement listener and use parser */
    parser.expr.enterRule(arithmeticListener)
  }

//  def parse(input: String) = {
//    println("\nEvaluating expression " + input)
//
//    val charStream = new ANTLRInputStream(input)
//    val lexer = new ArithmeticLexer(charStream)
//    val tokens = new CommonTokenStream(lexer)
//    val parser = new ArithmeticParser(tokens)
//
//    val arithmeticListener = new ArithmeticListenerApp()
//    /* Implement listener and use parser */
//    parser.expr.enterRule(arithmeticListener)
//  }

  parseSQL("SELECT * FROM x;")
}

import scala.jdk.CollectionConverters._
//class ArithmeticListenerApp extends ArithmeticParserBaseListener {
//
//  override def enterExpr(ctx: ArithmeticParser.ExprContext): Unit = {
//    val exprText = ctx.getText
//    println(s"Expression after tokenization = $exprText")
//
//    val operands = ctx.NUMBER().asScala.map(_.getText)
//    val operand1 = parseDouble(operands.lift(0).getOrElse("0.0")).getOrElse(0.0)
//    val operand2 = parseDouble(operands.lift(1).getOrElse("0.0")).getOrElse(0.0)
//
//    val operation = ctx.operation().getText
//
//    calculate(operand1, operand2, operation) match {
//      case Some(result) =>
//        println(s"Result of $operand1 $operation $operand2 = $result")
//      case None =>
//        println(s"Failed to evaluate expression. Tokenized expr = $exprText")
//    }
//
//  }
//
//  def parseDouble(s: String): Option[Double] = Try(s.toDouble).toOption
//
//  def calculate(op1: Double, op2: Double, operation: String): Option[Double] = {
//    operation match {
//      case "+" => Some(op1 + op2)
//      case "-" => Some(op1 - op2)
//      case "*" => Some(op1 * op2)
//      case "/" => Try(op1 / op2).toOption
//
//      case _ =>
//        println(s"Unsupported operation")
//        None
//    }
//
//  }
//}
