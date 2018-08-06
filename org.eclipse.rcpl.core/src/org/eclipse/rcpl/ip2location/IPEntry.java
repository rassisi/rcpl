/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.eclipse.rcpl.ip2location;

import java.io.Serializable;

/**
 * Created by evilisn_jiang(evilisn_jiang@trendmicro.com.cn)) on 2016/4/10.
 */

public class IPEntry implements Serializable {

	// Two-character country code based on ISO 3166.
	private String country_code;

	// Country name based on ISO 3166.
	private String country_name;

	// Region or state name.
	private String region_name;

	// City name.
	private String city_name;

	// Latitude of city.
	private Double latitude;

	// Longitude of city.
	private Double longitude;

	private Long ip_from;

	private Long ip_to;

	private String postCode;

	public String getCountry_code() {
		return country_code;
	}

	public String getCountry_name() {
		return country_name;
	}

	public String getRegion_name() {
		return region_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public long getIp_from() {
		return ip_from;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setIp_from(long ip_from) {
		this.ip_from = ip_from;
	}

	public long getIp_to() {
		return ip_to;
	}

	public void setIp_to(long ip_to) {
		this.ip_to = ip_to;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}