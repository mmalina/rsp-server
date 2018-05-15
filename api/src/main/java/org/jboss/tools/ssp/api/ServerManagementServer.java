/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/
package org.jboss.tools.ssp.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.lsp4j.jsonrpc.services.JsonSegment;
import org.jboss.tools.ssp.api.beans.CreateServerAttributes;
import org.jboss.tools.ssp.api.beans.DiscoveryPath;
import org.jboss.tools.ssp.api.beans.ServerAttributes;
import org.jboss.tools.ssp.api.beans.ServerBean;
import org.jboss.tools.ssp.api.beans.ServerHandle;
import org.jboss.tools.ssp.api.beans.ServerType;
import org.jboss.tools.ssp.api.beans.StartServerAttributes;
import org.jboss.tools.ssp.api.beans.Status;
import org.jboss.tools.ssp.api.beans.StopServerAttributes;

@JsonSegment("server")
public interface ServerManagementServer {
//	
//	/**
//	 * The `server/getVMs` request is sent by the client to fetch 
//	 * a list of VMs that are able to be used 
//	 */
//	@JsonRequest
//	CompletableFuture<List<VMDescription>> getVMs();
//
//	/**
//	 * The `server/addVM` request is sent by the client to add
//	 * a new java virtual machine to the server's list of VMs for 
//	 * use by any java-based server.
//	 */
//	@JsonNotification
//	void addVM(VMDescription description);
//
//	/**
//	 * The `server/removeVM` request is sent by the client to remove
//	 * a java virtual machine from the server's list of VMs for 
//	 * use by any java-based server.
//	 */
//	@JsonNotification
//	public void removeVM(VMHandle vm);
	
	/**
	 * The `server/getDiscoveryPaths` request is sent by the client to fetch 
	 * a list of discovery paths that can be searched. 
	 */
	@JsonRequest
	CompletableFuture<List<DiscoveryPath>> getDiscoveryPaths();

	
	/**
	 * The `server/findServerBeans` request is sent by the client to fetch 
	 * a list of server beans for the given path 
	 */
	@JsonRequest
	CompletableFuture<List<ServerBean>> findServerBeans(DiscoveryPath path);
	
	/**
	 * The `server/addDiscoveryPath` notification is sent by the client to add a new path
	 * to search when discovering servers.
	 */
	@JsonNotification
	void addDiscoveryPath(DiscoveryPath path);
	
	/**
	 * The `server/removeDiscoveryPath` notification is sent by the client to 
	 * remove a path from the list to search when discovering servers.
	 */
	@JsonNotification
	void removeDiscoveryPath(DiscoveryPath path);
	
	/**
	 * The `server/getServerHandles` request is sent by the client to 
	 * list the server adapters currently configured.
	 */
	@JsonRequest
	CompletableFuture<List<ServerHandle>> getServerHandles();
	

	/**
	 * The `server/getServerTypes` request is sent by the client to 
	 * list the server types currently supported.
	 */
	@JsonRequest
	CompletableFuture<List<String>> getServerTypes();
	
	
	/**
	 * The `server/deleteServer` notification is sent by the client to 
	 * delete a server from the model.
	 */
	@JsonNotification
	void deleteServer(ServerHandle handle);
	
	/**
	 * The `server/getRequiredAttributes` request is sent by the client to 
	 * list the server adapters currently configured.
	 */
	@JsonRequest
	CompletableFuture<CreateServerAttributes> getRequiredAttributes(ServerType type);
	
	/**
	 * The `server/getOptionalAttributes` request is sent by the client to 
	 * list the server adapters currently configured.
	 */
	@JsonRequest
	CompletableFuture<CreateServerAttributes> getOptionalAttributes(ServerType type);
	
	/**
	 * The `server/createServer` request is sent by the client to 
	 * add a server to the model.
	 */
	@JsonRequest
	CompletableFuture<Status> createServer(ServerAttributes csa);
	
	/**
	 * The `server/startServerAsync` request is sent by the client to 
	 * the server to start an existing server in the model.
	 */	
	@JsonRequest
	CompletableFuture<Status> startServerAsync(StartServerAttributes attr);
	
	/**
	 * The `server/stopServerAsync` request is sent by the client to 
	 * the server to stop an existing server in the model.
	 */		@JsonRequest
	CompletableFuture<Status> stopServerAsync(StopServerAttributes attr);
	
	/**
	 * The `server/shutdown` notification is sent by the client to 
	 * shut down the server
	 */
	@JsonNotification
	void shutdown();
}
