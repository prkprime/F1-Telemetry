### tcpdump

1. command used to capture network packets
   ```sh
   sudo tcpdump -i wlan0 host 192.168.0.3 and port 20777 and udp -X -w test.pcap
   ```
2. this tool is used to capture and write network packets to a file

### tcpreplay

1. command used to replay network packets
   ```sh
   sudo tcpreplay -i wlan0 test.pcap
   ```
2. this tool is used to replay network packets from a file
   NOTE: my linux server stops working as soon as i run this command, so couldn't test it.