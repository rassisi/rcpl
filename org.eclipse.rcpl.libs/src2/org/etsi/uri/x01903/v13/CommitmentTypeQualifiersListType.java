/*
 * XML Type:  CommitmentTypeQualifiersListType
 * Namespace: http://uri.etsi.org/01903/v1.3.2#
 * Java type: org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType
 *
 * Automatically generated - do not modify.
 */
package org.etsi.uri.x01903.v13;


/**
 * An XML CommitmentTypeQualifiersListType(@http://uri.etsi.org/01903/v1.3.2#).
 *
 * This is a complex type.
 */
public interface CommitmentTypeQualifiersListType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CommitmentTypeQualifiersListType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("commitmenttypequalifierslisttype2d24type");
    
    /**
     * Gets a List of "CommitmentTypeQualifier" elements
     */
    java.util.List<org.etsi.uri.x01903.v13.AnyType> getCommitmentTypeQualifierList();
    
    /**
     * Gets array of all "CommitmentTypeQualifier" elements
     * @deprecated
     */
    org.etsi.uri.x01903.v13.AnyType[] getCommitmentTypeQualifierArray();
    
    /**
     * Gets ith "CommitmentTypeQualifier" element
     */
    org.etsi.uri.x01903.v13.AnyType getCommitmentTypeQualifierArray(int i);
    
    /**
     * Returns number of "CommitmentTypeQualifier" element
     */
    int sizeOfCommitmentTypeQualifierArray();
    
    /**
     * Sets array of all "CommitmentTypeQualifier" element
     */
    void setCommitmentTypeQualifierArray(org.etsi.uri.x01903.v13.AnyType[] commitmentTypeQualifierArray);
    
    /**
     * Sets ith "CommitmentTypeQualifier" element
     */
    void setCommitmentTypeQualifierArray(int i, org.etsi.uri.x01903.v13.AnyType commitmentTypeQualifier);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "CommitmentTypeQualifier" element
     */
    org.etsi.uri.x01903.v13.AnyType insertNewCommitmentTypeQualifier(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "CommitmentTypeQualifier" element
     */
    org.etsi.uri.x01903.v13.AnyType addNewCommitmentTypeQualifier();
    
    /**
     * Removes the ith "CommitmentTypeQualifier" element
     */
    void removeCommitmentTypeQualifier(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType newInstance() {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.etsi.uri.x01903.v13.CommitmentTypeQualifiersListType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
