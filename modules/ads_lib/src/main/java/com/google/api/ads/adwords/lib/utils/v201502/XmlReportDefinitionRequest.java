// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.lib.utils.v201502;

import com.google.api.ads.adwords.lib.jaxb.v201502.DownloadFormat;
import com.google.api.ads.adwords.lib.jaxb.v201502.ReportDefinition;
import com.google.api.ads.adwords.lib.utils.ReportRequest;
import com.google.api.ads.common.lib.soap.jaxb.JaxBSerializer;
import com.google.common.base.Preconditions;

import javax.xml.namespace.QName;

/**
 * ReportRequest for XML-based report definitions.
 * 
 * @author Josh Radcliff
 */
class XmlReportDefinitionRequest implements ReportRequest {

  private final ReportDefinition reportDefinition;
  
  // Static so we hold only a single reference of the JAXBContext
  private static final JaxBSerializer<ReportDefinition> SERIALIZER =
      new JaxBSerializer<ReportDefinition>(ReportDefinition.class, new QName("reportDefinition"));
  
  public XmlReportDefinitionRequest(ReportDefinition reportDefinition) {
    this.reportDefinition = Preconditions.checkNotNull(reportDefinition, "Null report definition");
  }

  @Override
  public String getReportRequestString() {
    return SERIALIZER.serialize(reportDefinition);
  }

  @Override
  public DownloadFormat getDownloadFormat() {
    return reportDefinition.getDownloadFormat();
  }

  @Override
  public RequestType getRequestType() {
    return RequestType.XML;
  }
}
