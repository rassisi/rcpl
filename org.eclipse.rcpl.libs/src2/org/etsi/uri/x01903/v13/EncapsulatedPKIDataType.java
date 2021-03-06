/*
 * XML Type:  EncapsulatedPKIDataType
 * Namespace: http://uri.etsi.org/01903/v1.3.2#
 * Java type: org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
 *
 * Automatically generated - do not modify.
 */
package org.etsi.uri.x01903.v13;


/**
 * An XML EncapsulatedPKIDataType(@http://uri.etsi.org/01903/v1.3.2#).
 *
 * This is an atomic type that is a restriction of org.etsi.uri.x01903.v13.EncapsulatedPKIDataType.
 */
public interface EncapsulatedPKIDataType extends org.apache.xmlbeans.XmlBase64Binary
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EncapsulatedPKIDataType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("encapsulatedpkidatatype4081type");
    
    /**
     * Gets the "Id" attribute
     */
    java.lang.String getId();
    
    /**
     * Gets (as xml) the "Id" attribute
     */
    org.apache.xmlbeans.XmlID xgetId();
    
    /**
     * True if has "Id" attribute
     */
    boolean isSetId();
    
    /**
     * Sets the "Id" attribute
     */
    void setId(java.lang.String id);
    
    /**
     * Sets (as xml) the "Id" attribute
     */
    void xsetId(org.apache.xmlbeans.XmlID id);
    
    /**
     * Unsets the "Id" attribute
     */
    void unsetId();
    
    /**
     * Gets the "Encoding" attribute
     */
    java.lang.String getEncoding();
    
    /**
     * Gets (as xml) the "Encoding" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetEncoding();
    
    /**
     * True if has "Encoding" attribute
     */
    boolean isSetEncoding();
    
    /**
     * Sets the "Encoding" attribute
     */
    void setEncoding(java.lang.String encoding);
    
    /**
     * Sets (as xml) the "Encoding" attribute
     */
    void xsetEncoding(org.apache.xmlbeans.XmlAnyURI encoding);
    
    /**
     * Unsets the "Encoding" attribute
     */
    void unsetEncoding();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType newInstance() {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.etsi.uri.x01903.v13.EncapsulatedPKIDataType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.etsi.uri.x01903.v13.EncapsulatedPKIDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
