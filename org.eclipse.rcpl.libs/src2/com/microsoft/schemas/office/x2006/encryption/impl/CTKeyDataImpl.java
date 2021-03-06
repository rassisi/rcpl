/*
 * XML Type:  CT_KeyData
 * Namespace: http://schemas.microsoft.com/office/2006/encryption
 * Java type: com.microsoft.schemas.office.x2006.encryption.CTKeyData
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.office.x2006.encryption.impl;
/**
 * An XML CT_KeyData(@http://schemas.microsoft.com/office/2006/encryption).
 *
 * This is a complex type.
 */
public class CTKeyDataImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.office.x2006.encryption.CTKeyData
{
    
    public CTKeyDataImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SALTSIZE$0 = 
        new javax.xml.namespace.QName("", "saltSize");
    private static final javax.xml.namespace.QName BLOCKSIZE$2 = 
        new javax.xml.namespace.QName("", "blockSize");
    private static final javax.xml.namespace.QName KEYBITS$4 = 
        new javax.xml.namespace.QName("", "keyBits");
    private static final javax.xml.namespace.QName HASHSIZE$6 = 
        new javax.xml.namespace.QName("", "hashSize");
    private static final javax.xml.namespace.QName CIPHERALGORITHM$8 = 
        new javax.xml.namespace.QName("", "cipherAlgorithm");
    private static final javax.xml.namespace.QName CIPHERCHAINING$10 = 
        new javax.xml.namespace.QName("", "cipherChaining");
    private static final javax.xml.namespace.QName HASHALGORITHM$12 = 
        new javax.xml.namespace.QName("", "hashAlgorithm");
    private static final javax.xml.namespace.QName SALTVALUE$14 = 
        new javax.xml.namespace.QName("", "saltValue");
    
    
    /**
     * Gets the "saltSize" attribute
     */
    public int getSaltSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SALTSIZE$0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "saltSize" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STSaltSize xgetSaltSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STSaltSize target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STSaltSize)get_store().find_attribute_user(SALTSIZE$0);
            return target;
        }
    }
    
    /**
     * Sets the "saltSize" attribute
     */
    public void setSaltSize(int saltSize)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SALTSIZE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SALTSIZE$0);
            }
            target.setIntValue(saltSize);
        }
    }
    
    /**
     * Sets (as xml) the "saltSize" attribute
     */
    public void xsetSaltSize(com.microsoft.schemas.office.x2006.encryption.STSaltSize saltSize)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STSaltSize target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STSaltSize)get_store().find_attribute_user(SALTSIZE$0);
            if (target == null)
            {
                target = (com.microsoft.schemas.office.x2006.encryption.STSaltSize)get_store().add_attribute_user(SALTSIZE$0);
            }
            target.set(saltSize);
        }
    }
    
    /**
     * Gets the "blockSize" attribute
     */
    public int getBlockSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BLOCKSIZE$2);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "blockSize" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STBlockSize xgetBlockSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STBlockSize target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STBlockSize)get_store().find_attribute_user(BLOCKSIZE$2);
            return target;
        }
    }
    
    /**
     * Sets the "blockSize" attribute
     */
    public void setBlockSize(int blockSize)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BLOCKSIZE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BLOCKSIZE$2);
            }
            target.setIntValue(blockSize);
        }
    }
    
    /**
     * Sets (as xml) the "blockSize" attribute
     */
    public void xsetBlockSize(com.microsoft.schemas.office.x2006.encryption.STBlockSize blockSize)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STBlockSize target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STBlockSize)get_store().find_attribute_user(BLOCKSIZE$2);
            if (target == null)
            {
                target = (com.microsoft.schemas.office.x2006.encryption.STBlockSize)get_store().add_attribute_user(BLOCKSIZE$2);
            }
            target.set(blockSize);
        }
    }
    
    /**
     * Gets the "keyBits" attribute
     */
    public long getKeyBits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(KEYBITS$4);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "keyBits" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STKeyBits xgetKeyBits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STKeyBits target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STKeyBits)get_store().find_attribute_user(KEYBITS$4);
            return target;
        }
    }
    
    /**
     * Sets the "keyBits" attribute
     */
    public void setKeyBits(long keyBits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(KEYBITS$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(KEYBITS$4);
            }
            target.setLongValue(keyBits);
        }
    }
    
    /**
     * Sets (as xml) the "keyBits" attribute
     */
    public void xsetKeyBits(com.microsoft.schemas.office.x2006.encryption.STKeyBits keyBits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STKeyBits target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STKeyBits)get_store().find_attribute_user(KEYBITS$4);
            if (target == null)
            {
                target = (com.microsoft.schemas.office.x2006.encryption.STKeyBits)get_store().add_attribute_user(KEYBITS$4);
            }
            target.set(keyBits);
        }
    }
    
    /**
     * Gets the "hashSize" attribute
     */
    public int getHashSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HASHSIZE$6);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "hashSize" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STHashSize xgetHashSize()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STHashSize target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STHashSize)get_store().find_attribute_user(HASHSIZE$6);
            return target;
        }
    }
    
    /**
     * Sets the "hashSize" attribute
     */
    public void setHashSize(int hashSize)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HASHSIZE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(HASHSIZE$6);
            }
            target.setIntValue(hashSize);
        }
    }
    
    /**
     * Sets (as xml) the "hashSize" attribute
     */
    public void xsetHashSize(com.microsoft.schemas.office.x2006.encryption.STHashSize hashSize)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STHashSize target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STHashSize)get_store().find_attribute_user(HASHSIZE$6);
            if (target == null)
            {
                target = (com.microsoft.schemas.office.x2006.encryption.STHashSize)get_store().add_attribute_user(HASHSIZE$6);
            }
            target.set(hashSize);
        }
    }
    
    /**
     * Gets the "cipherAlgorithm" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm.Enum getCipherAlgorithm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CIPHERALGORITHM$8);
            if (target == null)
            {
                return null;
            }
            return (com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "cipherAlgorithm" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm xgetCipherAlgorithm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm)get_store().find_attribute_user(CIPHERALGORITHM$8);
            return target;
        }
    }
    
    /**
     * Sets the "cipherAlgorithm" attribute
     */
    public void setCipherAlgorithm(com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm.Enum cipherAlgorithm)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CIPHERALGORITHM$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CIPHERALGORITHM$8);
            }
            target.setEnumValue(cipherAlgorithm);
        }
    }
    
    /**
     * Sets (as xml) the "cipherAlgorithm" attribute
     */
    public void xsetCipherAlgorithm(com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm cipherAlgorithm)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm)get_store().find_attribute_user(CIPHERALGORITHM$8);
            if (target == null)
            {
                target = (com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm)get_store().add_attribute_user(CIPHERALGORITHM$8);
            }
            target.set(cipherAlgorithm);
        }
    }
    
    /**
     * Gets the "cipherChaining" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STCipherChaining.Enum getCipherChaining()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CIPHERCHAINING$10);
            if (target == null)
            {
                return null;
            }
            return (com.microsoft.schemas.office.x2006.encryption.STCipherChaining.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "cipherChaining" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STCipherChaining xgetCipherChaining()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STCipherChaining target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STCipherChaining)get_store().find_attribute_user(CIPHERCHAINING$10);
            return target;
        }
    }
    
    /**
     * Sets the "cipherChaining" attribute
     */
    public void setCipherChaining(com.microsoft.schemas.office.x2006.encryption.STCipherChaining.Enum cipherChaining)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CIPHERCHAINING$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CIPHERCHAINING$10);
            }
            target.setEnumValue(cipherChaining);
        }
    }
    
    /**
     * Sets (as xml) the "cipherChaining" attribute
     */
    public void xsetCipherChaining(com.microsoft.schemas.office.x2006.encryption.STCipherChaining cipherChaining)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STCipherChaining target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STCipherChaining)get_store().find_attribute_user(CIPHERCHAINING$10);
            if (target == null)
            {
                target = (com.microsoft.schemas.office.x2006.encryption.STCipherChaining)get_store().add_attribute_user(CIPHERCHAINING$10);
            }
            target.set(cipherChaining);
        }
    }
    
    /**
     * Gets the "hashAlgorithm" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm.Enum getHashAlgorithm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HASHALGORITHM$12);
            if (target == null)
            {
                return null;
            }
            return (com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "hashAlgorithm" attribute
     */
    public com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm xgetHashAlgorithm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm)get_store().find_attribute_user(HASHALGORITHM$12);
            return target;
        }
    }
    
    /**
     * Sets the "hashAlgorithm" attribute
     */
    public void setHashAlgorithm(com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm.Enum hashAlgorithm)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HASHALGORITHM$12);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(HASHALGORITHM$12);
            }
            target.setEnumValue(hashAlgorithm);
        }
    }
    
    /**
     * Sets (as xml) the "hashAlgorithm" attribute
     */
    public void xsetHashAlgorithm(com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm hashAlgorithm)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm target = null;
            target = (com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm)get_store().find_attribute_user(HASHALGORITHM$12);
            if (target == null)
            {
                target = (com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm)get_store().add_attribute_user(HASHALGORITHM$12);
            }
            target.set(hashAlgorithm);
        }
    }
    
    /**
     * Gets the "saltValue" attribute
     */
    public byte[] getSaltValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SALTVALUE$14);
            if (target == null)
            {
                return null;
            }
            return target.getByteArrayValue();
        }
    }
    
    /**
     * Gets (as xml) the "saltValue" attribute
     */
    public org.apache.xmlbeans.XmlBase64Binary xgetSaltValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBase64Binary target = null;
            target = (org.apache.xmlbeans.XmlBase64Binary)get_store().find_attribute_user(SALTVALUE$14);
            return target;
        }
    }
    
    /**
     * Sets the "saltValue" attribute
     */
    public void setSaltValue(byte[] saltValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SALTVALUE$14);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SALTVALUE$14);
            }
            target.setByteArrayValue(saltValue);
        }
    }
    
    /**
     * Sets (as xml) the "saltValue" attribute
     */
    public void xsetSaltValue(org.apache.xmlbeans.XmlBase64Binary saltValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBase64Binary target = null;
            target = (org.apache.xmlbeans.XmlBase64Binary)get_store().find_attribute_user(SALTVALUE$14);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBase64Binary)get_store().add_attribute_user(SALTVALUE$14);
            }
            target.set(saltValue);
        }
    }
}
