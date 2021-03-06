/*
 * Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.dynamodb.model;

/**
 * <p>
 * AttributeValue can be String, Number, StringSet, NumberSet.
 * </p>
 */
public class AttributeValue {

    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. Strings
     * are Unicode with UTF-8 binary encoding. The maximum size is limited by
     * the size of the primary key (1024 bytes as a range part of a key or
     * 2048 bytes as a single part hash key) or the item size (64k).
     */
    private String s;

    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. Numbers
     * are positive or negative exact-value decimals and integers. A number
     * can have up to 38 digits precision and can be between 10^-128 to
     * 10^+126.
     */
    private String n;

    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Strings.
     */
    private java.util.List<String> sS;

    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Numbers.
     */
    private java.util.List<String> nS;

    /**
     * Default constructor for a new AttributeValue object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public AttributeValue() {}
    
    /**
     * Constructs a new AttributeValue object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param s AttributeValue can be String, Number, StringSet, NumberSet.
     * Strings are Unicode with UTF-8 binary encoding. The maximum size is
     * limited by the size of the primary key (1024 bytes as a range part of
     * a key or 2048 bytes as a single part hash key) or the item size (64k).
     */
    public AttributeValue(String s) {
        this.s = s;
    }

    
    
    /**
     * Constructs a new AttributeValue object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param sS AttributeValue can be String, Number, StringSet, NumberSet.
     * A Set of Strings.
     */
    public AttributeValue(java.util.List<String> sS) {
        this.sS = sS;
    }

    
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. Strings
     * are Unicode with UTF-8 binary encoding. The maximum size is limited by
     * the size of the primary key (1024 bytes as a range part of a key or
     * 2048 bytes as a single part hash key) or the item size (64k).
     *
     * @return AttributeValue can be String, Number, StringSet, NumberSet. Strings
     *         are Unicode with UTF-8 binary encoding. The maximum size is limited by
     *         the size of the primary key (1024 bytes as a range part of a key or
     *         2048 bytes as a single part hash key) or the item size (64k).
     */
    public String getS() {
        return s;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. Strings
     * are Unicode with UTF-8 binary encoding. The maximum size is limited by
     * the size of the primary key (1024 bytes as a range part of a key or
     * 2048 bytes as a single part hash key) or the item size (64k).
     *
     * @param s AttributeValue can be String, Number, StringSet, NumberSet. Strings
     *         are Unicode with UTF-8 binary encoding. The maximum size is limited by
     *         the size of the primary key (1024 bytes as a range part of a key or
     *         2048 bytes as a single part hash key) or the item size (64k).
     */
    public void setS(String s) {
        this.s = s;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. Strings
     * are Unicode with UTF-8 binary encoding. The maximum size is limited by
     * the size of the primary key (1024 bytes as a range part of a key or
     * 2048 bytes as a single part hash key) or the item size (64k).
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param s AttributeValue can be String, Number, StringSet, NumberSet. Strings
     *         are Unicode with UTF-8 binary encoding. The maximum size is limited by
     *         the size of the primary key (1024 bytes as a range part of a key or
     *         2048 bytes as a single part hash key) or the item size (64k).
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public AttributeValue withS(String s) {
        this.s = s;
        return this;
    }
    
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. Numbers
     * are positive or negative exact-value decimals and integers. A number
     * can have up to 38 digits precision and can be between 10^-128 to
     * 10^+126.
     *
     * @return AttributeValue can be String, Number, StringSet, NumberSet. Numbers
     *         are positive or negative exact-value decimals and integers. A number
     *         can have up to 38 digits precision and can be between 10^-128 to
     *         10^+126.
     */
    public String getN() {
        return n;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. Numbers
     * are positive or negative exact-value decimals and integers. A number
     * can have up to 38 digits precision and can be between 10^-128 to
     * 10^+126.
     *
     * @param n AttributeValue can be String, Number, StringSet, NumberSet. Numbers
     *         are positive or negative exact-value decimals and integers. A number
     *         can have up to 38 digits precision and can be between 10^-128 to
     *         10^+126.
     */
    public void setN(String n) {
        this.n = n;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. Numbers
     * are positive or negative exact-value decimals and integers. A number
     * can have up to 38 digits precision and can be between 10^-128 to
     * 10^+126.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param n AttributeValue can be String, Number, StringSet, NumberSet. Numbers
     *         are positive or negative exact-value decimals and integers. A number
     *         can have up to 38 digits precision and can be between 10^-128 to
     *         10^+126.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public AttributeValue withN(String n) {
        this.n = n;
        return this;
    }
    
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Strings.
     *
     * @return AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     *         Strings.
     */
    public java.util.List<String> getSS() {
        
        return sS;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Strings.
     *
     * @param sS AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     *         Strings.
     */
    public void setSS(java.util.Collection<String> sS) {
        if (sS == null) {
            this.sS = null;
            return;
        }

        java.util.List<String> sSCopy = new java.util.ArrayList<String>(sS.size());
        sSCopy.addAll(sS);
        this.sS = sSCopy;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Strings.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param sS AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     *         Strings.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public AttributeValue withSS(String... sS) {
        if (getSS() == null) setSS(new java.util.ArrayList<String>(sS.length));
        for (String value : sS) {
            getSS().add(value);
        }
        return this;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Strings.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param sS AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     *         Strings.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public AttributeValue withSS(java.util.Collection<String> sS) {
        if (sS == null) {
            this.sS = null;
        } else {
            java.util.List<String> sSCopy = new java.util.ArrayList<String>(sS.size());
            sSCopy.addAll(sS);
            this.sS = sSCopy;
        }

        return this;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Numbers.
     *
     * @return AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     *         Numbers.
     */
    public java.util.List<String> getNS() {
        
        return nS;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Numbers.
     *
     * @param nS AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     *         Numbers.
     */
    public void setNS(java.util.Collection<String> nS) {
        if (nS == null) {
            this.nS = null;
            return;
        }

        java.util.List<String> nSCopy = new java.util.ArrayList<String>(nS.size());
        nSCopy.addAll(nS);
        this.nS = nSCopy;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Numbers.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param nS AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     *         Numbers.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public AttributeValue withNS(String... nS) {
        if (getNS() == null) setNS(new java.util.ArrayList<String>(nS.length));
        for (String value : nS) {
            getNS().add(value);
        }
        return this;
    }
    
    /**
     * AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     * Numbers.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param nS AttributeValue can be String, Number, StringSet, NumberSet. A Set of
     *         Numbers.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public AttributeValue withNS(java.util.Collection<String> nS) {
        if (nS == null) {
            this.nS = null;
        } else {
            java.util.List<String> nSCopy = new java.util.ArrayList<String>(nS.size());
            nSCopy.addAll(nS);
            this.nS = nSCopy;
        }

        return this;
    }
    
    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (s != null) sb.append("S: " + s + ", ");
        if (n != null) sb.append("N: " + n + ", ");
        if (sS != null) sb.append("SS: " + sS + ", ");
        if (nS != null) sb.append("NS: " + nS + ", ");
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getS() == null) ? 0 : getS().hashCode()); 
        hashCode = prime * hashCode + ((getN() == null) ? 0 : getN().hashCode()); 
        hashCode = prime * hashCode + ((getSS() == null) ? 0 : getSS().hashCode()); 
        hashCode = prime * hashCode + ((getNS() == null) ? 0 : getNS().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
    
        if (obj instanceof AttributeValue == false) return false;
        AttributeValue other = (AttributeValue)obj;
        
        if (other.getS() == null ^ this.getS() == null) return false;
        if (other.getS() != null && other.getS().equals(this.getS()) == false) return false; 
        if (other.getN() == null ^ this.getN() == null) return false;
        if (other.getN() != null && other.getN().equals(this.getN()) == false) return false; 
        if (other.getSS() == null ^ this.getSS() == null) return false;
        if (other.getSS() != null && other.getSS().equals(this.getSS()) == false) return false; 
        if (other.getNS() == null ^ this.getNS() == null) return false;
        if (other.getNS() != null && other.getNS().equals(this.getNS()) == false) return false; 
        return true;
    }
    
}
    