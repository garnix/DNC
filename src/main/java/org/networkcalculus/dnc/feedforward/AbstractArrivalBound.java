/*
 * This file is part of the Deterministic Network Calculator (DNC).
 *
 * Copyright (C) 2013 - 2018 Steffen Bondorf
 * Copyright (C) 2017 - 2018 The DiscoDNC contributors
 * Copyright (C) 2019+ The DNC contributors
 *
 * http://networkcalculus.org
 *
 *
 * The Deterministic Network Calculator (DNC) is free software;
 * you can redistribute it and/or modify it under the terms of the 
 * GNU Lesser General Public License as published by the Free Software Foundation; 
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */

package org.networkcalculus.dnc.feedforward;

import org.networkcalculus.dnc.AnalysisConfig;
import org.networkcalculus.dnc.network.server_graph.ServerGraph;

public abstract class AbstractArrivalBound implements ArrivalBound {
    protected ServerGraph server_graph;
    protected AnalysisConfig configuration;

    public ServerGraph getServerGraph() {
        return server_graph;
    }

    public void setServerGraph(ServerGraph server_graph) {
        this.server_graph = server_graph;
    }

    public AnalysisConfig getConfiguration() {
        return configuration;
    }

    public void setConfiguration(AnalysisConfig configuration) {
        this.configuration = configuration;
    }
}
