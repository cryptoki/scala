package gitlog

import java.util.Locale

import gitlog.FrontEndJsonModel.Author
import gitlog.GitLogJsonModel.{GitLog, LogEntry}
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}

object GitLogService {


  /**
   * Count total number of commits
   */
  def countCommits(log: GitLog): Int = ???

  /**
   * Count commits of a specific author. Author is defined like "Matthias Erch <matthias.erche@epost-dev.de"
   */
  def countCommitsOfUser(log: GitLog, author: String): Int = ???

  /**
   * Count number of contributers.
   *
   * Duplicates caused by multiple mail addresses for the same contributer are allowed.
   */
  def countOfContributer(log: GitLog): Int = ???

  val inputFormatter: DateTimeFormatter = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss yyyy Z").withLocale(Locale.ENGLISH)
  val outputFormatter: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)

  /**
   * Use [[inputFormatter]] and [[outputFormatter]] to get a [[Map]] of number of commits per day
   */
  def logEntryPerDay(log: GitLog): Map[String, Int] = ???

  /**
   * Return a map of log entries per author name
   */
  def logEntryByName(log: GitLog): Map[String, Seq[LogEntry]] = ???

  /**
   * Hints:
   * - you may use split method of [[String]]
   * - arrays support a takeWhile and dropWhile method
   * - arrays support mkString to join ll elements to a string
   *
   */
  def authorFromLogEntry(logEntry: LogEntry): Author = ???

  /**
   * Transform a list of [[LogEntry]] into a list of [[Author]]
   */
  def authorFromLogEntries(logEntries: Seq[LogEntry]): Seq[Author] = ???

  /**
   * Get a specific author from a list of authors
   */
  def author(authors: Seq[Author], name: String): Author = ???


}