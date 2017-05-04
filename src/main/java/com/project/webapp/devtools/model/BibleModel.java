/**
 * 
 */
package com.project.webapp.devtools.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vamsi Ravi
 *
 */
public class BibleModel {

	@JsonProperty
	public String Book = null;
	
	@JsonProperty
	public String Chapter = null;
	
	@JsonProperty
	public String Verse = null;
	
	@JsonProperty
	public String VerseFrom = null;
	
	@JsonProperty
	public String VerseTo = null;
	
	@JsonProperty
	public String Output = null;

	/**
	 * @return the book
	 */
	public String getBook() {
		return Book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(String book) {
		Book = book;
	}

	/**
	 * @return the chapter
	 */
	public String getChapter() {
		return Chapter;
	}

	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(String chapter) {
		Chapter = chapter;
	}

	/**
	 * @return the verse
	 */
	public String getVerse() {
		return Verse;
	}

	/**
	 * @param verse the verse to set
	 */
	public void setVerse(String verse) {
		Verse = verse;
	}

	/**
	 * @return the verseFrom
	 */
	public String getVerseFrom() {
		return VerseFrom;
	}

	/**
	 * @param verseFrom the verseFrom to set
	 */
	public void setVerseFrom(String verseFrom) {
		VerseFrom = verseFrom;
	}

	/**
	 * @return the verseTo
	 */
	public String getVerseTo() {
		return VerseTo;
	}

	/**
	 * @param verseTo the verseTo to set
	 */
	public void setVerseTo(String verseTo) {
		VerseTo = verseTo;
	}

	/**
	 * @return the output
	 */
	public String getOutput() {
		return Output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(String output) {
		Output = output;
	}
	
}
