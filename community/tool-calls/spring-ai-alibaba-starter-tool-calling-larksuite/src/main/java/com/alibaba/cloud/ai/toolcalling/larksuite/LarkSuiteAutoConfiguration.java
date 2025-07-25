/*
 * Copyright 2024-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.cloud.ai.toolcalling.larksuite;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * @author 北极星
 * @author huaiziqing
 */
@Configuration
@EnableConfigurationProperties({ LarkSuiteProperties.class })
@ConditionalOnClass({ LarkSuiteProperties.class })
@ConditionalOnProperty(prefix = "spring.ai.alibaba.toolcalling.larksuite", name = "enabled", havingValue = "true",
		matchIfMissing = true)
public class LarkSuiteAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	@Description("It calls the document api to invoke a method to create a larksuite document")
	public LarkSuiteCreateDocService larksuiteCreateDocFunction(LarkSuiteProperties properties) {
		return new LarkSuiteCreateDocService(properties);
	}

	@Bean
	@ConditionalOnMissingBean
	@Description("It runs a api to invoke a method to send message including group and single chat")
	public LarkSuiteChatService larksuiteChatFunction(LarkSuiteProperties properties) {
		return new LarkSuiteChatService(properties);
	}

	@Bean
	@ConditionalOnMissingBean
	@Description("It calls the document api to invoke a method to create a larksuite sheet")
	public LarkSuiteCreateSheetService larksuiteCreateSheetFunction(LarkSuiteProperties properties) {
		return new LarkSuiteCreateSheetService(properties);
	}

	@Bean
	@ConditionalOnMissingBean
	@Description("It calls the document api to get content of a larksuite document")
	public LarkSuiteGetDocContentService larksuiteGetDocContentFunction(LarkSuiteProperties properties) {
		return new LarkSuiteGetDocContentService(properties);
	}

	@Bean
	@ConditionalOnMissingBean
	@Description("It calls the sheet api to get content of a larksuite sheet")
	public LarkSuiteGetSheetContentService larksuiteGetSheetContentFunction(LarkSuiteProperties properties) {
		return new LarkSuiteGetSheetContentService(properties);
	}

}
