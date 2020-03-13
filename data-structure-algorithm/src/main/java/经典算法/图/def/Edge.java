package 经典算法.图.def;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edge {
    int start;
    int end;
    int finalEnd;
    int weight;
}
