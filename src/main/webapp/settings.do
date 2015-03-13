<settings>
    <licensekey>V3#2860#D20151001#S1#aa5287c9560cd9f0-S14bab6ea9ced4f01-7130e20d4fc0f77d-T6cef807d592b0f5e-85025f9eccd1e5f9-c0c0b212d77d2f37-T9ed90c925d6e2aca-70142845e63d7ee3-3186304df9e148bb</licensekey>
<customer>telenet</customer>
<servers>
<server name="Telenet_NG" id="3"   >
  <method type="tcp" host="speedtest.telenet.be:8080" />

</server>
</servers>
<!--  Connection Templates: https://support.ookla.com/entries/23000438-NetGauge-Client-Configuration-Templates
 connection - broadband, fiber, lan
-->
<configuration connection="broadband" />
<!--  NetGauge settings:
 activetests - test list from speedtest,latency,packetloss,firewall
-->
<netgauge activetests="speed, latency" />
<!--  skiponfailure - Skip test when Java is missing instead of displaying an error
-->
<java skiponfailure="true" />
<interface clienticon="house"  incrementtemplate="100M"  template="mbps"  servericon="office" />
<!--  toprow and bottomrow form the end of test grid. That grid can be up to 2x5 - L=latency, P = packetloss, S = speed, F = firewall
See: https://support.ookla.com/entries/22679642-NetGauge-End-of-Test-Configuration
-->
<endoftest
        columns="5"
         toprow="LPFSS"
      bottomrow="JPFSS"
/>
<errors linktodocs="true" />
<linequality packetlosslength="100"  packetlosspause="20" />
<extras autostart="false"  repeat="0" />
<!--  enabled - Display IP available modes: disabled (0), local(1), API (2), IP+ISP (3)
-->
<ip enabled="1"  ip="%CLIENT_IP%" />
<reporting jsreporting="3" jscalls="4" />


</settings>