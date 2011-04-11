/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook;

import org.springframework.social.facebook.support.extractors.ProfileResponseExtractor;
import org.springframework.social.facebook.types.FacebookProfile;

class UserTemplate implements UserOperations {

	private ProfileResponseExtractor profileExtractor;
	private final GraphApi graphApi;

	public UserTemplate(GraphApi graphApi) {
		this.graphApi = graphApi;
		this.profileExtractor = new ProfileResponseExtractor();
	}

	public FacebookProfile getUserProfile() {
		return getUserProfile("me");
	}

	public FacebookProfile getUserProfile(String facebookId) {
		return graphApi.fetchObject(facebookId, profileExtractor);
	}

	public byte[] getUserProfileImage() {
		return getUserProfileImage("me");
	}
	
	public byte[] getUserProfileImage(String userId) {
		return graphApi.fetchImage(userId, "picture", ImageType.LARGE);
	}
}
