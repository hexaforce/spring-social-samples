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
package org.springframework.social.showcase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.social.connect.ServiceProviderConnection;
import org.springframework.social.connect.ServiceProviderConnectionRepository;
import org.springframework.social.facebook.api.FacebookApi;
import org.springframework.social.tripit.api.TripItApi;
import org.springframework.social.twitter.api.TwitterApi;

@Configuration
public class ServiceApisConfig {
	
	@Bean
	@Scope(value="request")
	public FacebookApi facebookApi(ServiceProviderConnectionRepository connectionRepository) {
		ServiceProviderConnection<FacebookApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(FacebookApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}
	
	@Bean
	@Scope(value="request")
	public TripItApi tripitApi(ServiceProviderConnectionRepository connectionRepository) {
		ServiceProviderConnection<TripItApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(TripItApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}

	@Bean
	@Scope(value="request")
	public TwitterApi twitterApi(ServiceProviderConnectionRepository connectionRepository) {
		ServiceProviderConnection<TwitterApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(TwitterApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}

}