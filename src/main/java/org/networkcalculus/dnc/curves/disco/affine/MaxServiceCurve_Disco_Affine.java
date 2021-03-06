/*
 * This file is part of the Deterministic Network Calculator (DNC).
 *
 * Copyright (C) 2005 - 2007 Frank A. Zdarsky
 * Copyright (C) 2016 Steffen Bondorf
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

package org.networkcalculus.dnc.curves.disco.affine;

import org.networkcalculus.dnc.Calculator;
import org.networkcalculus.dnc.curves.Curve;
import org.networkcalculus.dnc.curves.MaxServiceCurve;

public class MaxServiceCurve_Disco_Affine extends Curve_Disco_Affine implements MaxServiceCurve {
    // --------------------------------------------------------------------------------------------------------------
    // Constructors
    // --------------------------------------------------------------------------------------------------------------
    protected MaxServiceCurve_Disco_Affine() {
        super();
    }

    public MaxServiceCurve_Disco_Affine(int segment_count) {
        super(segment_count);
    }

    public MaxServiceCurve_Disco_Affine(Curve curve) {
        copy(curve);
        forceThroughOrigin();

        // Too strong requirement: !isAlmostConcave()
        if (Calculator.getInstance().exec_max_service_curve_checks() && !isWideSenseIncreasing()) {
            throw new RuntimeException(
                    "Maximum service curves can only be created from wide-sense increasing functions.");
        }
    }

    public MaxServiceCurve_Disco_Affine(String max_service_curve_str) throws Exception {
    	// Smallest possible string: {(0,0),0}
        if (max_service_curve_str == null || max_service_curve_str.isEmpty() || max_service_curve_str.length() < 9) {
            throw new RuntimeException("Invalid string representation of a service curve.");
        }

        initializeCurve(max_service_curve_str);
        forceThroughOrigin();

        // Too strong requirement: !isAlmostConcave()
        if (Calculator.getInstance().exec_max_service_curve_checks() && !isWideSenseIncreasing()) {
            throw new RuntimeException(
                    "Maximum service curves can only be created from wide-sense increasing functions.");
        }
    }

    // --------------------------------------------------------------------------------------------------------------
    // Interface Implementations
    // --------------------------------------------------------------------------------------------------------------
    @Override
    public MaxServiceCurve_Disco_Affine copy() {
        MaxServiceCurve_Disco_Affine msc_copy = new MaxServiceCurve_Disco_Affine();
        msc_copy.copy(this);

        return msc_copy;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof MaxServiceCurve_Disco_Affine) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        return "MSC".hashCode() * super.hashCode();
    }

    /**
     * Returns a string representation of this curve.
     *
     * @return the curve represented as a string.
     */
    @Override
    public String toString() {
        return "MSC" + super.toString();
    }
}
