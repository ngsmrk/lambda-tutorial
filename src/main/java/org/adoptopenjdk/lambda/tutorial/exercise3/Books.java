package org.adoptopenjdk.lambda.tutorial.exercise3;

/*
 * #%L
 * lambda-tutorial
 * %%
 * Copyright (C) 2013 Adopt OpenJDK
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Domain object representing a collection of books
 */
public class Books {

    /**
     * Apply a mapping of Books to titles (Strings)
     *
     * @param books - books to transform
     * @return list of book titles
     */
    public static List<String> titlesOf(List<Book> books) {
        final Function<Book, String> function = Book::getTitle;
        return applyMapFunction(books, function);
    }

    /**
     * Apply a mapping of Books to their author's full names
     *
     * @param books - books to transform
     * @return list of author full names
     */
    public static List<String> namesOfAuthorsOf(List<Book> books) {
        final Function<Book, String> function = book -> book.getAuthor().fullName();
        return applyMapFunction(books, function);
    }

    private static List<String> applyMapFunction(List<Book> books, Function<Book, String> function) {
        return Collections.unmodifiableList(books.stream().map(function).collect(Collectors.toList()));
    }

    /**
     * Apply a mapping of Books to a unique set of their publishers
     *
     * @param books - books to transform
     * @return set of publishers
     */
    public static Set<Publisher> publishersRepresentedBy(List<Book> books) {
        final Function<Book, Publisher> function = book -> book.getPublisher();
        return Collections.unmodifiableSet(books.stream().map(function).collect(Collectors.toSet()));
    }
}
