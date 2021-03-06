// Copyright 2012 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.axis.utility.extension.delegates;

import com.google.api.ads.adwords.axis.utility.extension.util.ListUtil;
import com.google.api.ads.adwords.axis.utility.extension.util.SelectorFields;
import com.google.api.ads.adwords.axis.v201502.billing.BillingAccount;
import com.google.api.ads.adwords.axis.v201502.billing.BudgetOrder;
import com.google.api.ads.adwords.axis.v201502.billing.BudgetOrderOperation;
import com.google.api.ads.adwords.axis.v201502.billing.BudgetOrderServiceInterface;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.common.annotations.VisibleForTesting;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Specific AbstractGetMutateDelegate for {@link BudgetOrder}.
 *
 * <p>
 * Implementation is not thread-safe,
 * because AdWordsSession and Apache Axis service objects are not thread-safe.
 * </p>
 *
 * @author Julian Toledo
 */
public final class BudgetOrderDelegate extends 
    AbstractGetMutateDelegate<BudgetOrder, BudgetOrderOperation, BudgetOrderServiceInterface> {

  /**
   * Default Constructor.
   *
   * @param adWordsSession the {@code adWordsSession} to use with the delegate/service
   */
  public BudgetOrderDelegate(AdWordsSession adWordsSession, boolean newBilling) {
    super(adWordsSession, SelectorFields.BudgetOrder.all(newBilling), BudgetOrder.class,
        BudgetOrderOperation.class,  BudgetOrderServiceInterface.class);
  }

  /**
   * Constructor with custom service.
   *
   * @param adWordsSession the {@code adWordsSession} to use with the delegate/service
   * @param service the custom service class for the SOAP service
   */
  @VisibleForTesting
  BudgetOrderDelegate(
      AdWordsSession adWordsSession, BudgetOrderServiceInterface service, boolean newBilling) {
    super(adWordsSession, SelectorFields.BudgetOrder.all(newBilling), BudgetOrder.class,
        BudgetOrderOperation.class, service);
  }

  /**
   * Constructor with custom fields.
   *
   * @param adWordsSession the {@code adWordsSession} to use with the delegate/service
   * @param selectorFields for the Generic Selectors using the SelectorField class
   */
  public BudgetOrderDelegate(AdWordsSession adWordsSession,
      List<SelectorFields.BudgetOrder> selectorFields) {
    super(adWordsSession, selectorFields, BudgetOrder.class, BudgetOrderOperation.class,
        BudgetOrderServiceInterface.class);
  }

  /**
   * Retrieves all BillingAccounts for the ManagedCustomer.
   *
   * @return all the BillingAccounts for the ManagedCustomer associate with the adWordsSession
   * @throws RemoteException for communication-related exceptions
   */
  public List<BillingAccount> getBillingAccounts() throws RemoteException {
    return ListUtil.asList(getService().getBillingAccounts());
  }

  /**
   * Retrieves BudgetOrders by id.
   *
   * @param id
   * @return a list of BudgetOrders matching the id
   * @throws RemoteException for communication-related exceptions
   */
  public BudgetOrder getById(Long id) throws RemoteException {
    return getOneByField(SelectorFields.BudgetOrder.ID, id);
  }

  /**
   * Retrieves BudgetOrders by billingAccountId.
   *
   * @param billingAccountId
   * @return a list of BudgetOrders matching the billingAccountId
   * @throws RemoteException for communication-related exceptions
   */
  public List<BudgetOrder> getByBillingAccountId(Long billingAccountId) throws RemoteException {
    return getByField(SelectorFields.BudgetOrder.BILLING_ACCOUNT_ID, billingAccountId);
  }
}
