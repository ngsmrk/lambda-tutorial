package org.adoptopenjdk.lambda.tutorial.exercise5.musicplayer;

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

public interface UserRatedMusicLibrary extends MusicLibrary {

    StarRating userRatingOf(Song song);

    static class StarRatingConverter {
        public static Rating convert(StarRating starRating) {
            return new Rating(starRating.numberOfStars * 20);
        }
    }


    @Override
    default Rating ratingOf(Song song) {
        return StarRatingConverter.convert(userRatingOf(song));
    }
}
